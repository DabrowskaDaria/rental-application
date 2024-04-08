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

@Getter
@Setter
@AllArgsConstructor
@Table(name="invoices")
@Entity
public class Invoice {
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
