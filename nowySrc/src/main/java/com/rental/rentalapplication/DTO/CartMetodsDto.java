package com.rental.rentalapplication.DTO;

import com.rental.rentalapplication.Models.MethodOfPayment;
import com.rental.rentalapplication.Models.MethodOfReception;

import jakarta.validation.constraints.NotEmpty;

public class CartMetodsDto {

	
	private MethodOfReception methodsOfReception;
	
	
	private MethodOfPayment methodsOfPayment;


	public MethodOfReception getMethodsOfReception() {
		return methodsOfReception;
	}


	public void setMethodsOfReception(MethodOfReception methodsOfReception) {
		this.methodsOfReception = methodsOfReception;
	}


	public MethodOfPayment getMethodsOfPayment() {
		return methodsOfPayment;
	}


	public void setMethodsOfPayment(MethodOfPayment methodsOfPayment) {
		this.methodsOfPayment = methodsOfPayment;
	}


	
	
}
