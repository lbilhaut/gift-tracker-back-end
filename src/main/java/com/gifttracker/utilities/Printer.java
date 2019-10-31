package com.gifttracker.utilities;

import java.util.List;

import com.gifttracker.model.Gift;

public class Printer {
	
	public void printGifts(List<Gift> listOfGifts) {
		for(Gift gift : listOfGifts){
			 System.out.println(gift.getGiftName());	
			
		}
	}

}
