package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="image_display")
public class ImageDisplay {
	/*public ImageDisplay(String screenResolution, String matrixType, int lampPower) {
		super();
		this.screenResolution = screenResolution;
		this.matrixType = matrixType;
		this.lampPower = lampPower;
	}*/

	public ImageDisplay(String screenSize, String screenFormat, String activeSurface) {
		super();
		this.screenSize = screenSize;
		this.screenFormat = screenFormat;
		this.activeSurface = activeSurface;
	}

	public ImageDisplay(String screenResolution,String screenSize , int refreshRate) {
		super();
		this.screenSize = screenSize;
		this.screenResolution = screenResolution;
		this.refreshRate = refreshRate;
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

	public int getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(int refreshRate) {
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

	public int getLampPower() {
		return lampPower;
	}

	public void setLampPower(int lampPower) {
		this.lampPower = lampPower;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public ImageDisplay(String screenSize, String screenResolution, int refreshRate, String screenFormat,
			String activeSurface, String matrixType, int lampPower) {
		super();
		this.screenSize = screenSize;
		this.screenResolution = screenResolution;
		this.refreshRate = refreshRate;
		this.screenFormat = screenFormat;
		this.activeSurface = activeSurface;
		this.matrixType = matrixType;
		this.lampPower = lampPower;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="screen_size")
	private String screenSize;
	
	@Column(name="screen_resolution")
	private String screenResolution;
	
	@Column(name="refresh_rate")
	private int refreshRate;
	
	@Column(name="format")
	private String screenFormat;
	
	@Column(name="active_surface")
	private String activeSurface;
	
	@Column(name="matrix_type")
	private String matrixType;
	
	@Column(name="lamp_power")
	private int lampPower;
	
	@OneToMany(mappedBy = "imageDisplay", cascade = CascadeType.ALL)
	private List <Device> devices= new ArrayList<Device>();
}
