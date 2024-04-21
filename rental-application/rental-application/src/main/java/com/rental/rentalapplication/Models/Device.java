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


@Entity
@Table(name="devices")
public class Device {
	
	
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
	@JoinColumn(name ="fk_audio_devices_id")
	private AudioDevice audioDevice;
	
	@ManyToOne()
	@JoinColumn(name ="fk_lighting_id")
	private Lighting lighting;
	
	@NotNull
	private String name;
	@NotNull
	private Integer price;
	@NotNull
	private Integer deposit;
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
	
	public Device() {
		super();
	}

	
	public Device(Category category, Computer computer, ImageDisplay imageDisplay, Camera camera,
			AudioDevice audioDevice, Lighting lighting, @NotNull String name, @NotNull Integer price, @NotNull Integer deposit,
			@NotNull String description) {
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
	}
	
	public Device(Category category, Computer computer, ImageDisplay imageDisplay, Camera camera,
			AudioDevice audioDevice, Lighting lighting, @NotNull String name, @NotNull Integer price, @NotNull Integer deposit,
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
	
	public void addConnector(Connector connector) {
		deviceConnector.add(new DeviceConnector(connector,this));
	}
	
	public void addCart(Cart cart) {
		deviceCart.add(new DeviceCart(cart, this));
	}
	
	public void addFavouriteList(FavouriteList favouriteList) {
		devicefavouriteList.add(new DeviceFavouriteList(this, favouriteList));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public ImageDisplay getImageDisplay() {
		return imageDisplay;
	}

	public void setImageDisplay(ImageDisplay imageDisplay) {
		this.imageDisplay = imageDisplay;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public AudioDevice getAudioDevice() {
		return audioDevice;
	}

	public void setAudioDevice(AudioDevice audioDevice) {
		this.audioDevice = audioDevice;
	}

	public Lighting getLighting() {
		return lighting;
	}

	public void setLighting(Lighting lighting) {
		this.lighting = lighting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DeviceConnector> getDeviceConnector() {
		return deviceConnector;
	}

	public void setDeviceConnector(List<DeviceConnector> deviceConnector) {
		this.deviceConnector = deviceConnector;
	}

	public List<DeviceFavouriteList> getDevicefavouriteList() {
		return devicefavouriteList;
	}

	public void setDevicefavouriteList(List<DeviceFavouriteList> devicefavouriteList) {
		this.devicefavouriteList = devicefavouriteList;
	}

	public List<DeviceCart> getDeviceCart() {
		return deviceCart;
	}

	public void setDeviceCart(List<DeviceCart> deviceCart) {
		this.deviceCart = deviceCart;
	}

	public List<DeviceRental> getDeviceRental() {
		return deviceRental;
	}

	public void setDeviceRental(List<DeviceRental> deviceRental) {
		this.deviceRental = deviceRental;
	}

	

	
}
