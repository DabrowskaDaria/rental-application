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



@Entity
@Table(name="rentals")
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="rental_start_date")
	@NotNull
	private LocalDate rentalStartDate;
	
	@Column(name="rental_end_date")
	@NotNull
	private LocalDate rentalEndDate;
	
	@ManyToOne
	@JoinColumn(name="fk_rental_status_id")
	@NotNull
	private RentalStatus rentalStatus;
	
	@ManyToOne
	@JoinColumn(name="fk_method_of_reception_id")
	private MethodOfReception methodOfReception;
	
	
	@ManyToOne
	@JoinColumn(name="fk_method_of_payment_id")
	private MethodOfPayment methodOfPayment;
	
	@ManyToOne
	@JoinColumn(name="fk_users_id")
	private User user;

	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	List<DeviceRental> deviceRentals = new ArrayList<DeviceRental>();
	
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	List<Invoice> invoices = new ArrayList<Invoice>();

	public Rental() {
		super();
	}

	public Rental(@NotNull LocalDate rentalStartDate, @NotNull LocalDate rentalEndDate,
			@NotNull RentalStatus rentalStatus, User user) {
		super();
		this.rentalStartDate = rentalStartDate;
		this.rentalEndDate = rentalEndDate;
		this.rentalStatus = rentalStatus;
		this.user = user;
	}


	


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


	public RentalStatus getRentalStatus() {
		return rentalStatus;
	}


	public void setRentalStatus(RentalStatus rentalStatus) {
		this.rentalStatus = rentalStatus;
	}


	public MethodOfReception getMethodOfReception() {
		return methodOfReception;
	}


	public void setMethodOfReception(MethodOfReception methodOfReception) {
		this.methodOfReception = methodOfReception;
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


	public MethodOfPayment getMethodOfPayment() {
		return methodOfPayment;
	}


	public void setMethodOfPayment(MethodOfPayment methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
	}


}
