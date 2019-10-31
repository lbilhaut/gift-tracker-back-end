package com.gifttracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcFamilyDao implements FamilyDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcFamilyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	@Override
	public void saveFamily(Family family, Long userId) {
		Long id = getNextId();
		System.out.println("User id is " + userId);
		String insertSqlQueryString = "INSERT INTO families (family_id, user_id, family_nickname, family_name, address_street, address_city, address_zipcode,"
								+ "address_state, parent1_firstname, parent1_email, parent1_phone_number, " +
								"parent2_firstname, parent2_email, parent2_phone_number, notes)"+ 
								"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		jdbcTemplate.update(insertSqlQueryString, id, userId, family.getFamilyNickname(), family.getFamilyName(), family.getAddressStreet(), family.getAddressCity(),
				family.getAddressZipcode(), family.getAddressState(), family.getParent1FirstName(), family.getParent1Email(),
				family.getParent1PhoneNumber(), family.getParent2FirstName(), family.getParent2Email(), family.getParent2PhoneNumber(), family.getNotes());
		family.setFamilyId(id);	
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('families_family_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next family id");
		}
	}

	@Override
	public List<Family> getListOfFamilies(Long userId) {

		List<Family> listOfFamilies = new ArrayList<Family>();
		
		String sqlQuery = "SELECT * FROM families WHERE user_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, userId);
		
		while(results.next()) {
			Family family = new Family();
			family.setFamilyId(results.getLong("family_id"));
			family.setUserId(results.getLong("user_id"));
			family.setFamilyNickname(results.getString("family_nickname"));
			family.setFamilyName(results.getString("family_name"));
			family.setAddressStreet(results.getString("address_street"));
			family.setAddressCity(results.getString("address_city"));
			family.setAddressZipcode(results.getString("address_zipcode"));
			family.setAddressState(results.getString("address_state"));
			family.setParent1FirstName(results.getString("parent1_firstname"));
			family.setParent1Email(results.getString("parent1_email"));
			family.setParent1PhoneNumber(results.getString("parent1_phone_number"));
			family.setParent2FirstName(results.getString("parent2_firstname"));
			family.setParent2Email(results.getString("parent2_email"));
			family.setParent2PhoneNumber(results.getString("parent2_phone_number"));
			family.setNotes(results.getString("notes"));
			listOfFamilies.add(family);
		}
		
		return listOfFamilies;
	}

	@Override
	public List<String> getListOfFamilyNames(Long userId) {
		List<String> listOfFamilyNames = new ArrayList<String>();
		String selectAllNames = "SELECT family_name FROM families WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectAllNames, userId);
		
		while(results.next()) {
			String name = results.getString("family_name");
			listOfFamilyNames.add(name);
		}
		
//		System.out.println("List of Families");
//		System.out.println(listOfFamilyNames);
		
		return listOfFamilyNames;
	}

	@Override
	public Long getFamilyIdFromFamilyName(String familyName) {
		String sqlQuery = "SELECT family_name, family_id FROM families"
		+ " WHERE family_name = ?;";
		
		SqlRowSet  results =  jdbcTemplate.queryForRowSet(sqlQuery, familyName);
		
		results.next();
		Long id = results.getLong("family_id");
		System.out.println("Id of family " + familyName + " is "+ id);
		return id;
	}

	@Override
	public Long getFamilyIdFromUserIdAndFamilyName(Long userId, String familyName) {
		String sqlQuery = "SELECT family_name, family_id FROM families"
				+ " WHERE family_name = ? AND user_id = ?;";
				
				SqlRowSet  results =  jdbcTemplate.queryForRowSet(sqlQuery, familyName, userId);
				
				results.next();
				Long id = results.getLong("family_id");
				System.out.println("Id of family " + familyName + " is "+ id);
				return id;	
		
		
	}

}
