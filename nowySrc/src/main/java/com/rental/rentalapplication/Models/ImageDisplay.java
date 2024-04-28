package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="image_display")
public class ImageDisplay {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="screen_size", nullable = true)
	private String screenSize;
	
	@Column(name="screen_resolution", nullable = true)
	private String screenResolution;
	
	@Column(name="refresh_rate", nullable = true)
	private Integer refreshRate;
	
	@Column(name="format", nullable = true)
	private String screenFormat;
	
	@Column(name="active_surface", nullable = true)
	private String activeSurface;
	
	@Column(name="matrix_type", nullable = true)
	private String matrixType;
	
	@Column(name="lamp_power", nullable = true)
	private Integer lampPower;
	
	@OneToMany(mappedBy = "imageDisplay", cascade = CascadeType.ALL)
	private List <Device> devices= new ArrayList<Device>();
	
	public ImageDisplay() {
		super();
	}
	public ImageDisplay(String screenFormat, String screenSize, String activeSurface) {
		super();
		this.screenSize = screenSize;
		this.screenFormat = screenFormat;
		this.activeSurface = activeSurface;
	}

	public ImageDisplay(String screenResolution,String screenSize , Integer refreshRate) {
		super();
		this.screenSize = screenSize;
		this.screenResolution = screenResolution;
		this.refreshRate = refreshRate;
	}

	public ImageDisplay(String matrixType,Integer lampPower,String screenResolution) {
		super();
		this.screenResolution = screenResolution;
		this.matrixType = matrixType;
		this.lampPower = lampPower;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getScreenResolution() {
		return screenResolution;
	}

	public void setScreenResolution(String screenResolution) {
		this.screenResolution = screenResolution;
	}

	public Integer getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(Integer refreshRate) {
		this.refreshRate = refreshRate;
	}

	public String getScreenFormat() {
		return screenFormat;
	}

	public void setScreenFormat(String screenFormat) {
		this.screenFormat = screenFormat;
	}

	public String getActiveSurface() {
		return activeSurface;
	}

	public void setActiveSurface(String activeSurface) {
		this.activeSurface = activeSurface;
	}

	public String getMatrixType() {
		return matrixType;
	}

	public void setMatrixType(String matrixType) {
		this.matrixType = matrixType;
	}

	public Integer getLampPower() {
		return lampPower;
	}

	public void setLampPower(Integer lampPower) {
		this.lampPower = lampPower;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	

}
