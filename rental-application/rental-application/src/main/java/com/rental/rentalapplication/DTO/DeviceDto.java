package com.rental.rentalapplication.DTO;

import java.util.Map;

import com.rental.rentalapplication.Models.Category;

public class DeviceDto {
	
	
	private String name;
	
	private int price;
	
	private int deposit;
	
	private String description;
	
	private Category category;
	
	private Map<String, String> technicalDetails;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Map<String, String> getTechnicalDetails() {
		return technicalDetails;
	}
	public void setTechnicalDetails(Map<String, String> technicalDetails) {
		this.technicalDetails = technicalDetails;
	}
}
