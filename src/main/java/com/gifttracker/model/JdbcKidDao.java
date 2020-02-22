package com.gifttracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcKidDao implements KidDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcKidDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	private FamilyDao daoFamily;
	
	@Override
	public boolean saveKid(Kid kid, String familyName, Long userId) {
		Long id = getNextId();
		if(familyName.equals("No Family")) {
			kid.setFamilyId(null);
		}
		else {
			kid.setFamilyId(daoFamily.getFamilyIdFromFamilyName(familyName));
		}
		if(!checkDuplicateKids(kid, familyName, userId)) {
			String insertSqlQueryString = "INSERT INTO kids (kid_id, user_id, firstname, nickname, family_id, birth_year)"+ 
					" VALUES (?,?,?,?,?,?) ";
			jdbcTemplate.update(insertSqlQueryString, id, kid.getUserId(), kid.getFirstname(), kid.getNickname(), kid.getFamilyId(), kid.getBirthYear());
			return true;
		}
		return false;
	}



private boolean checkDuplicateKids(Kid kid, String familyName, Long userId) {
	int duplicate = 0;
	
	if(kid.getFamilyId() != null) {
		String sqlQuery = "SELECT COUNT(*) FROM kids WHERE firstname = ? AND user_id = ? AND family_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, kid.getFirstname(), userId, kid.getFamilyId());
		results.next();
		duplicate = results.getInt(1);		
	}
	else {
		String sqlQuery = "SELECT COUNT(*) FROM kids WHERE firstname = ? AND user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, kid.getFirstname(), userId);
		results.next();
		duplicate = results.getInt(1);
		}
	if(duplicate == 0) {
		return false;
	}
	return true;		
	}



private Long getNextId() {
	String sqlSelectNextId = "SELECT NEXTVAL('kids_kid_id_seq')";
	SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
	if(result.next()) {
		return result.getLong(1);
	} else {
		throw new RuntimeException("Something went wrong while getting the next product id");
	}
}

	
	
	@Override
	public List<String> getListOfKidNames(Long userId) {
				
		List<String> listOfKidNames = new ArrayList<String>();
		String selectAllNames = "SELECT firstname FROM kids WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectAllNames, userId);
		
		while(results.next()) {
			String name = results.getString("firstname");
			listOfKidNames.add(name);
		}

		return listOfKidNames;

	}


	@Override
	public Long getKidIdFromKidName(String firstname, Long userId) {
		String sqlQuery = "SELECT kid_id FROM kids WHERE firstname = ? AND user_id = ?;";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, firstname, userId);
		results.next();
		return results.getLong("kid_id");
	}


	@Override
	public List<Kid> getListOfKids(Long userId) {
		List<Kid> listOfKids = new ArrayList<Kid>();
		
		String sqlQuery = "SELECT * from kids WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, userId);
		
		while(results.next()) {
			Kid kid = new Kid();
			kid.setKidId(results.getLong("kid_id"));
			kid.setFirstname(results.getString("firstname"));
			kid.setNickname(results.getString("nickname"));
			kid.setFamilyId(results.getLong("family_id"));
			kid.setBirthYear(results.getLong("birth_year"));
			listOfKids.add(kid);			
		}
		
		return listOfKids;
	}


	@Override
	public Kid getKidFromId(Long kidId) {
		String sqlQuery = "SELECT * from kids WHERE kid_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, kidId);
		Kid kid = new Kid();
		results.next();
		kid.setKidId(results.getLong("kid_id"));
		kid.setFirstname(results.getString("firstname"));
		kid.setNickname(results.getString("nickname"));
		kid.setFamilyId(results.getLong("family_id"));
		kid.setBirthYear(results.getLong("birth_year"));
		return kid;
	}


	@Override
	public void updateKid(Long kidId, Kid updatedKid) {
		String sqlQuery = "UPDATE kids SET firstname = ?, nickname = ?, family_id = ?, birth_year = ? "
				+ " WHERE kid_id = ?;";
		jdbcTemplate.update(sqlQuery, updatedKid.getFirstname(), updatedKid.getNickname(), updatedKid.getFamilyId(), updatedKid.getBirthYear(), kidId);
	}


	@Override
	public void deleteKid(Long kidId) {
		String sqlQuery = "DELETE FROM gifts WHERE kid_id = ?;";
		jdbcTemplate.update(sqlQuery, kidId);
		sqlQuery = "DELETE FROM kids WHERE kid_id = ?;";
		jdbcTemplate.update(sqlQuery, kidId);
	}


	@Override
	public Long getKidIdFromKidNameAndUserId(String kidFirstname, Long userId) {
		Kid kid = getKidFromId(getKidIdFromKidName(kidFirstname, userId));
		String sqlQuery;
		if(kid.getFamilyId() != 0) {
		sqlQuery = "SELECT kid_id FROM kids WHERE firstname = ? and family_id IN "
				+ "(SELECT family_id from families where user_id = ? );";
		}
		else {
			sqlQuery = "SELECT kid_id FROM kids WHERE firstname = ? and user_id =?";		
		}

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, kidFirstname, userId);
		results.next();
		return results.getLong("kid_id");
	}

	@Override
	public List<Long> getListOfUniqueFamilyId(Long userId) {
		
		List<Long> listOfUniqueFamilyId = new ArrayList<Long>();
		String queryString = "SELECT DISTINCT family_id FROM kids WHERE user_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, userId);
		
		while(results.next()) {
			Long id = results.getLong("family_id");
			listOfUniqueFamilyId.add(id);
		}
				
		return listOfUniqueFamilyId;

	}
	
}
