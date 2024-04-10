package com.rental.rentalapplication.Models;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="rentals")
public class Rental {
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getRentalStartDate() {
		return rentalStartDate;
	}


	public void setRentalStartDate(LocalDate rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}


	public LocalDate getRentalEndDate() {
		return rentalEndDate;
	}


	public void setRentalEndDate(LocalDate rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}


	public String getRentalStatus() {
		return rentalStatus;
	}


	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}


	public String getDeliveryMethod() {
		return deliveryMethod;
	}


	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<DeviceRental> getDeviceRentals() {
		return deviceRentals;
	}


	public void setDeviceRentals(List<DeviceRental> deviceRentals) {
		this.deviceRentals = deviceRentals;
	}


	public List<Invoice> getInvoices() {
		return invoices;
	}


	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}


	public Rental(@NotNull LocalDate rentalStartDate, @NotNull LocalDate rentalEndDate, @NotNull String rentalStatus,
			@NotNull String deliveryMethod, @NotNull String paymentMethod, User user, List<DeviceRental> deviceRentals,
			List<Invoice> invoices) {
		super();
		this.rentalStartDate = rentalStartDate;
		this.rentalEndDate = rentalEndDate;
		this.rentalStatus = rentalStatus;
		this.deliveryMethod = deliveryMethod;
		this.paymentMethod = paymentMethod;
		this.user = user;
		this.deviceRentals = deviceRentals;
		this.invoices = invoices;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="rental_start_date")
	@NotNull
	private LocalDate rentalStartDate;
	
	@Column(name="rental_end_date")
	@NotNull
	private LocalDate rentalEndDate;
	
	@Column(name="rental_status")
	@NotNull
	private String rentalStatus;
	
	@Column(name="method_of_reception")
	@NotNull
	private String deliveryMethod;
	
	
	@Column(name="method_of_payment")
	@NotNull
	private String paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="fk_users_id")
	private User user;

	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	List<DeviceRental> deviceRentals = new ArrayList<DeviceRental>();
	
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	List<Invoice> invoices = new ArrayList<Invoice>();
}
