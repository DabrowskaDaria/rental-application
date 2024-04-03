package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name="fk_companies_id")
	private Company company;
	
	@Column(unique = true)
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@Column(name="account_type")
	@NotNull
	private String accountType;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rental> rental=new ArrayList<Rental>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private FavouriteList favouriteList;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Person person;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
}
