package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="carts")
public class Cart {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	List<DeviceCart> deviceCart= new ArrayList<DeviceCart>();
	
	@OneToOne
	@JoinColumn(name="fk_users_id")
	private User user;
	

	public Cart() {
		super();
	}

	public Cart(User user) {
		super();
		this.user = user;
	}
	
	public void addDeviceCart(DeviceCart deviceCart) {
		this.deviceCart.add(deviceCart);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DeviceCart> getDeviceCart() {
		return deviceCart;
	}

	public void setDeviceCart(List<DeviceCart> deviceCart) {
		this.deviceCart = deviceCart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
