package com.rental.rentalapplication.models;

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

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="companies")
public class Company {
	
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
