package com.rental.rentalapplication.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Entity
@Table(name = "devices_favourites_lists")
public class DeviceFavouriteList {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public FavouriteList getFavouriteList() {
		return favouriteList;
	}

	public void setFavouriteList(FavouriteList favouriteList) {
		this.favouriteList = favouriteList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="fk_devices_id")
	private Device device;
	
	@ManyToOne
	@JoinColumn(name="fk_favourites_lists_id")
	private FavouriteList favouriteList;
}
