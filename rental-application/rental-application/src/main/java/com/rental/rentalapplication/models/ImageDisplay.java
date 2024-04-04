package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="image_display")
public class ImageDisplay {
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
