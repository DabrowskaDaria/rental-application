package com.rental.rentalapplication.DTO;

import java.util.HashMap;
import java.util.Map;

import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Models.Connector;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class DeviceDto {

	private String name;
	
	private int price;
	
	private int deposit;
	
	private String description;
	
	private Category category;
	
	private Connector connector;
	
	private Map<String, String> technicalDetails= new HashMap<String, String>();
	
	public String getSpeakersPower() {
		return technicalDetails.get("speakersPower");
	}

	public int getNumberOfspeakers() {
		return Integer.valueOf(technicalDetails.get("numberOfspeakers"));
	}

	public String getFrequencyResponse() {
		return technicalDetails.get("frequencyResponse");
	}

	public String getMicrophoneType() {
		return technicalDetails.get("microphoneType");
	}

	public String getHeadphoneType() {
		return technicalDetails.get("headphoneType");
	}

	public boolean isMicrophone() {
		return Boolean.valueOf(technicalDetails.get("microphone")); 
	}

	public int getWorkingTime() {
		return Integer.valueOf(technicalDetails.get("workingTime")); 
	}

	public boolean isWirelessTransmission() {
		return Boolean.valueOf(technicalDetails.get("wirelessTransmission")); 
	}

	public String getResolution() {
		return technicalDetails.get("resolution");
	}

	public boolean isImageStabilization() {
		return Boolean.valueOf(technicalDetails.get("imageStabilization")); 
	}

	public boolean isOpticalZoom() {
		return Boolean.valueOf(technicalDetails.get("opticalZoom")); 
	}

	public String getDisplay() {
		return technicalDetails.get("display");
	}

	public String getProcesor() {
		return technicalDetails.get("procesor");
	}

	public String getDrive() {
		return technicalDetails.get("drive");
	}

	public int getRam() {
		return Integer.valueOf(technicalDetails.get("ram")); 
	}

	public String getGraphicsCard() {
		return technicalDetails.get("graphicsCard");
	}

	public String getOperatingSystem() {
		return technicalDetails.get("operatingSystem");
	}

	public String getLightingColor() {
		return technicalDetails.get("lightingColor");
	}

	public int getPowerConsumption() {
		return Integer.valueOf(technicalDetails.get("powerConsumption"));
	}

	public String getDeviceSize() {
		return technicalDetails.get("deviceSize");
	}

	public String getScreenSize() {
		return technicalDetails.get("activeSurface");
	}
	
	public int getRefreshRate() {
		return Integer.valueOf(technicalDetails.get("activeSurface"));
	}
	
	public String getScreenFormat() {
		return technicalDetails.get("screenFormat");
	}
	
	public String getActiveSurface() {
		return technicalDetails.get("activeSurface");
	}
	
	public String getMatrixType() {
		return technicalDetails.get("matrixType");
	}
	
	public int getLampPower() {
		return Integer.valueOf(technicalDetails.get("lampPower"));
	}
	
	public String getScreenResolution() {
		return technicalDetails.get("screenResolution");
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getDeposit() {
		return deposit;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Map<String, String> getTechnicalDetails() {
		return technicalDetails;
	}

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	
}
