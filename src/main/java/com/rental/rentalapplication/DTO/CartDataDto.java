package com.rental.rentalapplication.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

public class CartDataDto {

	@NotEmpty
	private LocalDate rentalStartDate;
	
	@NotEmpty
	private LocalDate rentalEndDate;
	
	public LocalDate getRentalStartDate() {
		return rentalStartDate;
	}

	public void setRentalStartDate(LocalDate rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}

	public LocalDate getRentalEndDate() {
		return rentalEndDate;
	}

	public void setRentalEndDate(LocalDate rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}

}
