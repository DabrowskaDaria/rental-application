package com.rental.rentalapplication.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Table(name="invoices")
@Entity
public class Invoice {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Invoice(@NotNull LocalDate invoiceDate, @NotNull int price, @NotNull int deposit,
			@NotNull String invoiceType, Rental rental) {
		super();
		this.invoiceDate = invoiceDate;
		this.price = price;
		this.deposit = deposit;
		this.invoiceType = invoiceType;
		this.rental = rental;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="invoice_date")
	@NotNull
	private LocalDate invoiceDate;
	
	@Column(name="total_price")
	@NotNull
	private int price;
	
	@Column(name="full_deposit")
	@NotNull
	private int deposit;
	
	@Column(name="invoice_type")
	@NotNull
	private String invoiceType;;
	
	@ManyToOne
	@JoinColumn(name="fk_rentals_id")
	private Rental rental;
	
}
