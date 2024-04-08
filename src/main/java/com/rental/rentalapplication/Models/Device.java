package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="devices")
public class Device {
	public Device(Category category, Computer computer, ImageDisplay imageDisplay, Camera camera,
			AudioDevice audioDevice, Lighting lighting, @NotNull String name, @NotNull int price, @NotNull int deposit,
			@NotNull String description, List<DeviceConnector> deviceConnector) {
		super();
		this.category = category;
		this.computer = computer;
		this.imageDisplay = imageDisplay;
		this.camera = camera;
		this.audioDevice = audioDevice;
		this.lighting = lighting;
		this.name = name;
		this.price = price;
		this.deposit = deposit;
		this.description = description;
		this.deviceConnector = deviceConnector;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name ="fk_device_categories_id")
	private Category category;
	
	@ManyToOne()
	@JoinColumn(name ="fk_computers_and_tablets_id")
	private Computer computer;
	
	@ManyToOne()
	@JoinColumn(name ="fk_image_display_id")
	private ImageDisplay imageDisplay;
	
	@ManyToOne()
	@JoinColumn(name ="fk_camera_id")
	private Camera camera;
	
	@ManyToOne()
	@JoinColumn(name ="fk_audio_devices__id")
	private AudioDevice audioDevice;
	
	@ManyToOne()
	@JoinColumn(name ="fk_lighting_id")
	private Lighting lighting;
	
	@NotNull
	private String name;
	@NotNull
	private int price;
	@NotNull
	private int deposit;
	@NotNull
	private String description;
	
	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<DeviceConnector> deviceConnector= new ArrayList<DeviceConnector>();
	
	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<DeviceFavouriteList> devicefavouriteList= new ArrayList<DeviceFavouriteList>();
	
	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<DeviceCart> deviceCart= new ArrayList<DeviceCart>();
	
	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<DeviceRental> deviceRental= new ArrayList<DeviceRental>();
}
