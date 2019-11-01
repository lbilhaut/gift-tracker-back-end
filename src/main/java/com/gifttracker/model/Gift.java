package com.gifttracker.model;

public class Gift {
	private Long giftId;
	private Long kidId;
	private String giftName;
	private String giftOccasion;
	private Long giftYear;
	private String giftPictureName;
	private String giftNotes;
	private String path;
	
//	public String getPath() {
//		String path="img/"+kidId+"/"+giftPictureName;
//		return path;
//	}
	public String getGiftPictureName() {
		return giftPictureName;
	}
	public void setGiftPictureName(String giftPictureName) {
		this.giftPictureName = giftPictureName;
	}
	public Long getGiftId() {
		return giftId;
	}
	public void setGiftId(Long giftId) {
		this.giftId = giftId;
	}
	public Long getKidId() {
		return kidId;
	}
	public void setKidId(Long kidId) {
		this.kidId = kidId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftOccasion() {
		return giftOccasion;
	}
	public void setGiftOccasion(String giftOccasion) {
		this.giftOccasion = giftOccasion;
	}
	public Long getGiftYear() {
		return giftYear;
	}
	public void setGiftYear(Long giftYear) {
		this.giftYear = giftYear;
	}
	public String getGiftNotes() {
		return giftNotes;
	}
	public void setGiftNotes(String giftNotes) {
		this.giftNotes = giftNotes;
	}

	
	
}
