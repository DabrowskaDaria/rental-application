package com.rental.rentalapplication.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="persons")
public class Person {
	public Person(@NotNull String firstName, @NotNull String surname, @NotNull String phoneNumber) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	@NotNull
	private String surname;
	
	@Column(name="pesel_number")
	private String pesel;
	
	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;
	
	private String place;
	
	private String street;
	
	@Column(name="house_number")
	private int houseNumber;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@OneToOne
	@JoinColumn(name="fk_users_id")
	private User user;
}
