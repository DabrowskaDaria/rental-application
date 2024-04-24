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


@AllArgsConstructor
@Table(name="invoices")
@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="invoice_date")
	@NotNull
	private LocalDate invoiceDate;
	
	@Column(name="total_price")
	@NotNull
	private Integer price;
	
	@Column(name="full_deposit")
	@NotNull
	private Integer deposit;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice_type_id")
	@NotNull
	private InvoiceType invoiceType;
	
	@ManyToOne
	@JoinColumn(name="fk_rentals_id")
	private Rental rental;
	
	public Invoice(@NotNull LocalDate invoiceDate, @NotNull Integer price, @NotNull Integer deposit,
			@NotNull InvoiceType invoiceType, Rental rental) {
		super();
		this.invoiceDate = invoiceDate;
		this.price = price;
		this.deposit = deposit;
		this.invoiceType = invoiceType;
		this.rental = rental;
	}
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

	public InvoiceType getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(InvoiceType invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	

	
	
}
