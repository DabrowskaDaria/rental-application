package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="connectors")
public class Connector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "connector", cascade = CascadeType.ALL)
	private List<DeviceConnector> deviceConnectors=new ArrayList<DeviceConnector>();
	
	public Connector() {
		super();
	}
	
	public void addDeviceConnectors(DeviceConnector deviceConnector) {
		deviceConnectors.add(deviceConnector);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeviceConnector> getDeviceConnectors() {
		return deviceConnectors;
	}

	public void setDeviceConnectors(List<DeviceConnector> deviceConnectors) {
		this.deviceConnectors = deviceConnectors;
	}

	public Connector(@NotNull String name) {
		super();
		this.name = name;
	}

	
}
