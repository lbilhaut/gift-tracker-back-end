package com.gifttracker.model;

public class Family {
	private Long familyId;
	private Long userId;
	private String familyNickname;
	private String familyName;
	private String addressStreet;
	private String addressCity;
	private String addressZipcode;
	private String addressState;
	private String parent1Firstname;
	private String parent1Email;
	private String parent1PhoneNumber;
	private String parent2Firstname;
	private String parent2Email;
	private String parent2PhoneNumber;
	private String notes;
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getParent1Firstname() {
		return parent1Firstname;
	}
	public void setParent1Firstname(String parent1Firstname) {
		this.parent1Firstname = parent1Firstname;
	}
	public String getParent2Firstname() {
		return parent2Firstname;
	}
	public void setParent2Firstname(String parent2Firstname) {
		this.parent2Firstname = parent2Firstname;
	}
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}
	public String getFamilyNickname() {
		return familyNickname;
	}
	public void setFamilyNickname(String familyNickname) {
		this.familyNickname = familyNickname;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getParent1FirstName() {
		return parent1Firstname;
	}
	public void setParent1FirstName(String parent1FirstName) {
		this.parent1Firstname = parent1FirstName;
	}
	public String getParent1Email() {
		return parent1Email;
	}
	public void setParent1Email(String parent1Email) {
		this.parent1Email = parent1Email;
	}
	public String getParent1PhoneNumber() {
		return parent1PhoneNumber;
	}
	public void setParent1PhoneNumber(String parent1PhoneNumber) {
		this.parent1PhoneNumber = parent1PhoneNumber;
	}
	public String getParent2FirstName() {
		return parent2Firstname;
	}
	public void setParent2FirstName(String parent2FirstName) {
		this.parent2Firstname = parent2FirstName;
	}
	public String getParent2Email() {
		return parent2Email;
	}
	public void setParent2Email(String parent2Email) {
		this.parent2Email = parent2Email;
	}
	public String getParent2PhoneNumber() {
		return parent2PhoneNumber;
	}
	public void setParent2PhoneNumber(String parent2PhoneNumber) {
		this.parent2PhoneNumber = parent2PhoneNumber;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
