package com.gifttracker.model;

import java.util.List;

public interface GiftDao {

	void saveGift(Gift newGift);

	List<Gift> getListOfGifts(Long kidId);
	
}
