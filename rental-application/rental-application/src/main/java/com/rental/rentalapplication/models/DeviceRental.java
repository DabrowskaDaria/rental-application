package com.rental.rentalapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="devices_rentals")
public class DeviceRental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="fk_rentals_id")
	private Rental rental;
	
	@ManyToOne
	@JoinColumn(name="fk_devices_id")
	private Device device;
}
