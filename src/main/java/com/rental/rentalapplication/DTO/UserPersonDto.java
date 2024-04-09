package com.rental.rentalapplication.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserPersonDto {
	
	@NotNull(message="Pole jest wymagane")
	@Email(message="Niepoprawny Email")
	private String email;
	
	@NotNull(message="Pole jest wymagane")

	@Size(min=8, message="Hasło musi mieć co najmniej 8 znaków")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z]).{8,}$",message="Hasło nie spełnia zasad złożoności")
	private String password;
	
	@NotNull(message="Pole jest wymagane")
	@Size(min=3, message="Pole za krótkie")
	private String firstName;
	
	@Size(min=3, message="Pole za krótkie")
	@NotNull(message="Pole jest wymagane")
	private String surname;
	
	@NotNull(message="Pole jest wymagane")
	@Size(min=9, message="Za krótki numer telefonu")
	private String phoneNumber;
	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	
}
