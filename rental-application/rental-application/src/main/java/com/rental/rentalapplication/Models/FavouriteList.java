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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Entity
@Table(name="favourites_lists")
public class FavouriteList {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DeviceFavouriteList> getDeviceFavouriteLists() {
		return deviceFavouriteLists;
	}

	public void setDeviceFavouriteLists(List<DeviceFavouriteList> deviceFavouriteLists) {
		this.deviceFavouriteLists = deviceFavouriteLists;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "favouriteList", cascade = CascadeType.ALL)
	List<DeviceFavouriteList> deviceFavouriteLists = new ArrayList<DeviceFavouriteList>();
	
	@OneToOne
	@JoinColumn(name="fk_users_id")
	private User user;
}
