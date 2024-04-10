package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="companies")
public class Company {
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComnapyNumber() {
		return comnapyNumber;
	}

	public void setComnapyNumber(String comnapyNumber) {
		this.comnapyNumber = comnapyNumber;
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

	public int getBuldingNumber() {
		return buldingNumber;
	}

	public void setBuldingNumber(int buldingNumber) {
		this.buldingNumber = buldingNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Company(String name, String comnapyNumber, String place, String street, int buldingNumber, String zipCode,
			List<User> users) {
		super();
		this.name = name;
		this.comnapyNumber = comnapyNumber;
		this.place = place;
		this.street = street;
		this.buldingNumber = buldingNumber;
		this.zipCode = zipCode;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(name="company_number")
	private String comnapyNumber;
	
	private String place;
	
	private String street;
	
	@Column(name="bulding_number")
	private int buldingNumber;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	List<User> users= new ArrayList<User>();
}
