package com.rental.rentalapplication.Models;

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


@Entity
@Table(name="users")
public class User {

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Rental> getRental() {
		return rental;
	}

	public void setRental(List<Rental> rental) {
		this.rental = rental;
	}

	public FavouriteList getFavouriteList() {
		return favouriteList;
	}

	public void setFavouriteList(FavouriteList favouriteList) {
		this.favouriteList = favouriteList;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public User(@NotNull String email, @NotNull String password) {
		super();
		this.email = email;
		this.password = password;
	}

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
