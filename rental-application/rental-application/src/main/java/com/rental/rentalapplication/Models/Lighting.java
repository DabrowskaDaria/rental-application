package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Table(name="lighting")
@Entity
public class Lighting {
	public Lighting(@NotNull String lightingColor, @NotNull int powerConsumption, @NotNull int lampPower,
			@NotNull String deviceSize) {
		super();
		this.lightingColor = lightingColor;
		this.powerConsumption = powerConsumption;
		this.lampPower = lampPower;
		this.deviceSize = deviceSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLightingColor() {
		return lightingColor;
	}

	public void setLightingColor(String lightingColor) {
		this.lightingColor = lightingColor;
	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public int getLampPower() {
		return lampPower;
	}

	public void setLampPower(int lampPower) {
		this.lampPower = lampPower;
	}

	public String getDeviceSize() {
		return deviceSize;
	}

	public void setDeviceSize(String deviceSize) {
		this.deviceSize = deviceSize;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lighting_color")
	@NotNull
	private String lightingColor;
	@NotNull
	@Column(name="power_consumption")
	private int powerConsumption;
	@NotNull
	@Column(name="lamp_power")
	private int lampPower;
	@NotNull
	@Column(name="device_size")
	private String deviceSize;
	
	@OneToMany(mappedBy = "lighting", cascade = CascadeType.ALL)
	private List<Device> devices=new ArrayList<Device>();
}
