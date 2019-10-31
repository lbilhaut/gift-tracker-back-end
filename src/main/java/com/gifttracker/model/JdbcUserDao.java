package com.gifttracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcUserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public void saveUser(User user) {
		System.out.println("In the save user method");
		Long id = getNextId();
		String insertSqlQueryString = "INSERT INTO users (user_id, username, hashed_password, firstname, "+
								"lastname, email, phone_number) " +
								"VALUES (?,?,?,?,?,?,?) ";
		jdbcTemplate.update(insertSqlQueryString, id, user.getUsername(), user.getHashedPassword(),
				user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhoneNumber());
		user.setUserId(id);
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('users_user_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next user id");
		}
	}


	@Override
	public List<String> getListOfUsernames() {
		List<String> listOfUsers = new ArrayList<String>();
		String sqlQuery = "SELECT username FROM users;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlQuery);
		while(result.next()) {
			listOfUsers.add(result.getString("username"));
		}
		return listOfUsers;
	}

	@Override
	public String getHashedPassword(String username) {
		System.out.println("In getHashedPassword");
		String queryString = "SELECT hashed_password FROM users WHERE username = ?;";
		System.out.println("Query string is " + queryString);
		SqlRowSet result = jdbcTemplate.queryForRowSet(queryString, username);
		result.next();
		return result.getString("hashed_password");
	}


	@Override
	public User getUser(String username) {
		User user = new User();
		String queryString = "SELECT * from users WHERE username = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(queryString, username);
		while(result.next()) {
			user.setUserId(result.getLong("user_id"));
			user.setUsername(result.getString("username"));
//			user.setHashedPassword(result.getString("hashed_password"));
			user.setFirstname(result.getString("firstname"));
			user.setLastname(result.getString("lastname"));
			user.setEmail(result.getString("email"));
			user.setPhoneNumber(result.getString("phone_number"));
		}
		return user;
	}
	
}
