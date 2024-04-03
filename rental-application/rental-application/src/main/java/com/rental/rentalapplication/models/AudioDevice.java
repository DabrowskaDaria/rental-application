package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="audio_devices")
public class AudioDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="speakers_power")
	private String speakersPower;

	@Column(name="number_of_speakers")
	private int numberOfspeakers;
	
	@Column(name="frequency_response")
	private String frequencyResponse;
	
	@Column(name="connection_type")
	private String connectionType; 
	
	@Column(name="headphone_type")
	private String headphoneType; 
	
	private boolean microphone;
	
	@Column(name="working_time")
	private int workingTime;
	
	@Column(name="wireless_transmission")
	private boolean wirelessTransmission;
	
	@OneToMany(mappedBy = "audioDevice", cascade = CascadeType.ALL)
	private List<Device> devices= new ArrayList<Device>();
}
