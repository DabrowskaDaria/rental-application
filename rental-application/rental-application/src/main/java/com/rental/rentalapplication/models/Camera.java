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
@AllArgsConstructor
@Entity
@Table(name="camera")
public class Camera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String resolution;
	@NotNull
	@Column(name="image_stabilization")
	private boolean imageStabilization;
	@NotNull
	@Column(name = "optical_zoom")
	private boolean opticalZoom;
	
	@OneToMany(mappedBy = "camera", cascade = CascadeType.ALL)
	private List <Device> devices= new ArrayList<Device>();
}
