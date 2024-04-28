package com.rental.rentalapplication.DTO;

import jakarta.validation.constraints.NotEmpty;

public class CartCostsDto {

	@NotEmpty
	private Integer totalPrice;
	
	@NotEmpty
	private Integer fullDeposit;

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getFullDeposit() {
		return fullDeposit;
	}

	public void setFullDeposit(Integer fullDeposit) {
		this.fullDeposit = fullDeposit;
	}
}
