package com.rental.rentalapplication.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Models.Connector;


public class DeviceDto {

	private String name;
	
	private Integer price;
	
	private Integer deposit;
	
	private String description;
	
	private Category category;
	
	private Connector connector;
	
	private Map<String, String> technicalDetails= new HashMap<String, String>();
	private List<Connector> connectors=new ArrayList<Connector>();
	
	public String getSpeakersPower() {
		return technicalDetails.get("speakersPower");
	}

	public int getNumberOfspeakers() {
		return Integer.parseInt(technicalDetails.get("numberOfspeakers"));
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

	public Integer getWorkingTime() {
		return Integer.parseInt(technicalDetails.get("workingTime")); 
	}

	public Boolean isWirelessTransmission() {
		return Boolean.valueOf(technicalDetails.get("wirelessTransmission")); 
	}

	public String getResolution() {
		return technicalDetails.get("resolution");
	}

	public Boolean isImageStabilization() {
		return Boolean.valueOf(technicalDetails.get("imageStabilization")); 
	}

	public Boolean isOpticalZoom() {
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
		return Integer.parseInt(technicalDetails.get("ram")); 
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
		return Integer.parseInt(technicalDetails.get("powerConsumption"));
	}

	public String getDeviceSize() {
		return technicalDetails.get("deviceSize");
	}

	public String getScreenSize() {
		return technicalDetails.get("screenSize");
	}
	
	public int getRefreshRate() {
		return Integer.parseInt(technicalDetails.get("refreshRate"));
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
		return Integer.parseInt(technicalDetails.get("lampPower"));
	}
	
	public String getScreenResolution() {
		return technicalDetails.get("screenResolution");
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

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public Integer getDeposit() {
		return deposit;
	}
	
	public String getDescription() {
		return description;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}

	public void setTechnicalDetails(Map<String, String> technicalDetails) {
		this.technicalDetails = technicalDetails;
	}
	

	
}
