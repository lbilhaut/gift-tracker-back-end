package com.gifttracker.model;

public class Kid {
	private Long kidId;
	private String firstname;
	private String nickname;
	private Long familyId;
	private Long birthYear;
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getKidId() {
		return kidId;
	}
	public void setKidId(Long id) {
		this.kidId = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}
	public Long getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Long birthYear) {
		this.birthYear = birthYear;
	}
	@Override
	public String toString() {
		return "Kid [kidId=" + kidId + ", firstname=" + firstname + ", familyId=" + familyId + ", userId=" + userId
				+ "]";
	}
	
	
}
