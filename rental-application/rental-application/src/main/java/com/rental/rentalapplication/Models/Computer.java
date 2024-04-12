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
@Table(name="computers_and_tablets")
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String display;
	@NotNull
	private String procesor;
	@NotNull
	private String drive;
	@NotNull
	@Column(name="RAM")
	private int ram;
	@Column(name="graphics_card")
	private String graphicsCard;
	@NotNull
	@Column(name="operating_system")
	private String operatingSystem;
	@OneToMany(mappedBy = "computer", cascade = CascadeType.ALL )
	
	private List<Device> devices= new ArrayList<Device>();
	
	
	public Computer(@NotNull String display, @NotNull String procesor, @NotNull String drive, @NotNull int ram,
			String graphicsCard, @NotNull String operatingSystem) {
		super();
		this.display = display;
		this.procesor = procesor;
		this.drive = drive;
		this.ram = ram;
		this.graphicsCard = graphicsCard;
		this.operatingSystem = operatingSystem;
	}
	
	public Computer(@NotNull String display, @NotNull String procesor, @NotNull String drive, @NotNull int ram,
			@NotNull String operatingSystem) {
		super();
		this.display = display;
		this.procesor = procesor;
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
	public String getProcesor() {
		return procesor;
	}
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getGraphicsCard() {
		return graphicsCard;
	}
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	
}
