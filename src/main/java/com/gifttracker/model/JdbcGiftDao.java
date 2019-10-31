package com.gifttracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcGiftDao implements GiftDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcGiftDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void saveGift(Gift gift) {
		Long id = getNextId();
		String insertSqlQueryString = "INSERT INTO gifts (gift_id, kid_id, gift_name, gift_occasion, gift_year, gift_picture_name, gift_notes)"+ 
				" VALUES (?,?,?,?,?,?,?) ";
		jdbcTemplate.update(insertSqlQueryString, id,gift.getKidId(), gift.getGiftName(), gift.getGiftOccasion(), gift.getGiftYear(), gift.getGiftPictureName(), gift.getGiftNotes());	

	}



	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('gifts_gift_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next product id");
		}

	}


	@Override
	public List<Gift> getListOfGifts(Long kidId) {
		String sqlQuery = "SELECT * FROM gifts WHERE kid_id=?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, kidId);
	
		List<Gift> listOfGift = new ArrayList<Gift>();
		
		while(results.next()) {
			Gift gift = new Gift();
			gift.setGiftId(results.getLong("gift_id"));
			gift.setKidId(results.getLong("kid_id"));
			gift.setGiftName(results.getString("gift_name"));
			gift.setGiftOccasion(results.getString("gift_occasion"));
			gift.setGiftYear(results.getLong("gift_year"));
			gift.setGiftPictureName(results.getString("gift_picture_name"));
			listOfGift.add(gift);
		}
		
		return listOfGift;
	}
}