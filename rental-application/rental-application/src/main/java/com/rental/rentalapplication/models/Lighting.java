package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="lighting")
@Entity
public class Lighting {
	public Lighting(@NotNull String lightingColor, @NotNull int powerConsumption, @NotNull int lampPower,
			@NotNull String deviceSize) {
		super();
		this.lightingColor = lightingColor;
		this.powerConsumption = powerConsumption;
		this.lampPower = lampPower;
		this.deviceSize = deviceSize;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lighting_color")
	@NotNull
	private String lightingColor;
	@NotNull
	@Column(name="power_consumption")
	private int powerConsumption;
	@NotNull
	@Column(name="lamp_power")
	private int lampPower;
	@NotNull
	@Column(name="device_size")
	private String deviceSize;
	
	@OneToMany(mappedBy = "lighting", cascade = CascadeType.ALL)
	private List<Device> devices=new ArrayList<Device>();
}
