package com.gifttracker.model;

import java.util.List;

public interface UserDao {
	
	public void saveUser(User user);

	public List<String> getListOfUsernames();

	public String getHashedPassword(String username);

	public User getUser(String username);


}
