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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="camera")
public class Camera {
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

	public boolean isImageStabilization() {
		return imageStabilization;
	}

	public void setImageStabilization(boolean imageStabilization) {
		this.imageStabilization = imageStabilization;
	}

	public boolean isOpticalZoom() {
		return opticalZoom;
	}

	public void setOpticalZoom(boolean opticalZoom) {
		this.opticalZoom = opticalZoom;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Camera(@NotNull String resolution, @NotNull boolean imageStabilization, @NotNull boolean opticalZoom,
			List<Device> devices) {
		super();
		this.resolution = resolution;
		this.imageStabilization = imageStabilization;
		this.opticalZoom = opticalZoom;
		this.devices = devices;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String resolution;
	@NotNull
	@Column(name="image_stabilization")
	private boolean imageStabilization;
	@NotNull
	@Column(name = "optical_zoom")
	private boolean opticalZoom;
	
	@OneToMany(mappedBy = "camera", cascade = CascadeType.ALL)
	private List <Device> devices= new ArrayList<Device>();
}
