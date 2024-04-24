package com.rental.rentalapplication.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	private String surname;
	
	@Column(name="pesel_number", nullable = true)
	private String pesel;
	
	@Column(name="phone_number", nullable = true)
	@NotNull
	private String phoneNumber;
	
	@Column(nullable = true)
	private String place;
	
	@Column(nullable = true)
	private String street;
	
	@Column(name="house_number", nullable = true)
	private String houseNumber;
	
	@Column(name="zip_code", nullable = true)
	private String zipCode;
	
	@OneToOne
	@JoinColumn(name="fk_users_id")
	private User user;
	
	public Person() {
		super();
	}

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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person(@NotNull String firstName, @NotNull String surname, @NotNull String phoneNumber) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

	
}
