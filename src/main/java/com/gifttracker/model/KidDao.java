package com.gifttracker.model;

import java.util.List;

public interface KidDao {
	public void saveKid(Kid kid);
	
	public List<String> getListOfKidNames(Long long1);

	public Long getKidIdFromKidName(String kidFirstname);

	public List<Kid> getListOfKids(Long long1);

	public Kid getKidFromId(Long kidId);

	public void updateKid(Long kidId, Kid updatedKid);

	public void deleteKid(Long kidId);

	public Long getKidIdFromKidNameAndUserId(String kidFirstname, Long userId);
	
}
