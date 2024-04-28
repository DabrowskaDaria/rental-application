package com.rental.rentalapplication.DTO;

import jakarta.validation.constraints.NotEmpty;

public class CartPersonCompanyDto {
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String surname;
	
	@NotEmpty
	private String peselNumber;
	
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	private String place;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String houseNumber;
	
	@NotEmpty
	private String zipCode;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String companyNumber;
	
	@NotEmpty
	private String buldingNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPeselNumber() {
		return peselNumber;
	}

	public void setPeselNumber(String peselNumber) {
		this.peselNumber = peselNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getBuldingNumber() {
		return buldingNumber;
	}

	public void setBuldingNumber(String buldingNumber) {
		this.buldingNumber = buldingNumber;
	}
	
}
