package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name="computers_and_tablets")
public class Computer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="operating_system")
	private String operatingSystem;
	
	@NotNull
	private Integer ram;
	
	@NotNull
	private String display;
	
	@NotNull
	private String processor;
	
	@NotNull
	private String drive;

	@Column(name="graphics_card", nullable = true)
	private String graphicsCard;

	@OneToMany(mappedBy = "computer", cascade = CascadeType.ALL )
	private List<Device> devices= new ArrayList<Device>();
	
	public Computer(@NotNull String display, @NotNull String processor, @NotNull String drive, @NotNull Integer ram, String graphicsCard,@NotNull String operatingSystem) {
		super();
		this.operatingSystem = operatingSystem;
		this.ram = ram;
		this.display = display;
		this.processor = processor;
		this.drive = drive;
		this.graphicsCard = graphicsCard;
	}
	public Computer() {
		super();
	}

	public Computer(@NotNull String display, @NotNull String processor, @NotNull String drive, @NotNull Integer ram, @NotNull String operatingSystem) {
		super();
		this.display = display;
		this.processor = processor;
		this.drive = drive;
		this.ram = ram;
		this.operatingSystem = operatingSystem;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public String getGraphicsCard() {
		return graphicsCard;
	}
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
	
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	
	
	
}
