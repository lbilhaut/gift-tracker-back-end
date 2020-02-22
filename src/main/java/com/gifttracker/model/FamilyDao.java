package com.gifttracker.model;

import java.util.List;

public interface FamilyDao {

	public void saveFamily(Family family, Long userId);

	public List<Family> getListOfFamilies(Long long1);

	public List<String> getListOfFamilyNames(Long long1);

	public Long getFamilyIdFromFamilyName(String familyName);

}
