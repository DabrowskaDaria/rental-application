package com.rental.rentalapplication.Controllers;

import java.util.HashMap;
import java.util.Map;

public class AddDeviceForm {
	
	private String category;
	private Map<String, String> technicalData;
	
	public AddDeviceForm() {
		technicalData= new HashMap<String, String>();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<String, String> getTechnicalData() {
		return technicalData;
	}

	public void setTechnicalData(Map<String, String> technicalData) {
		this.technicalData = technicalData;
	}
	
	
}
