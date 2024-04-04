package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="computers_and_tablets")
public class Computer {
	public Computer(@NotNull String display, @NotNull String procesor, @NotNull String drive, @NotNull int ram,
			String graphicsCard, @NotNull String operatingSystem) {
		super();
		this.display = display;
		this.procesor = procesor;
		this.drive = drive;
		this.ram = ram;
		this.graphicsCard = graphicsCard;
		this.operatingSystem = operatingSystem;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String display;
	@NotNull
	private String procesor;
	@NotNull
	private String drive;
	@NotNull
	@Column(name="RAM")
	private int ram;
	@Column(name="graphics_card")
	private String graphicsCard;
	@NotNull
	@Column(name="operating_system")
	private String operatingSystem;
	@OneToMany(mappedBy = "computer", cascade = CascadeType.ALL )
	private List<Device> devices= new ArrayList<Device>();
	
}
