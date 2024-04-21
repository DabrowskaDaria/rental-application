package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="camera")
public class Camera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String resolution;
	@NotNull
	@Column(name="image_stablization")
	private Boolean imageStabilization;
	@NotNull
	@Column(name = "optical_zoom")
	private Boolean opticalZoom;
	
	@OneToMany(mappedBy = "camera", cascade = CascadeType.ALL)
	private List <Device> devices= new ArrayList<Device>();
	
	public Camera() {
		super();
	}
	
	public Camera(@NotNull String resolution, @NotNull Boolean imageStabilization, @NotNull Boolean opticalZoom) {
		super();
		this.resolution = resolution;
		this.imageStabilization = imageStabilization;
		this.opticalZoom = opticalZoom;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Boolean isImageStabilization() {
		return imageStabilization;
	}

	public void setImageStabilization(Boolean imageStabilization) {
		this.imageStabilization = imageStabilization;
	}

	public Boolean isOpticalZoom() {
		return opticalZoom;
	}

	public void setOpticalZoom(Boolean opticalZoom) {
		this.opticalZoom = opticalZoom;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	

	
}
