package com.rental.rentalapplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="audio_devices")
public class AudioDevice {
	public AudioDevice(String speakersPower, int numberOfspeakers, String frequencyResponse, String connectionType,
			String headphoneType, boolean microphone, int workingTime, boolean wirelessTransmission,
			List<Device> devices) {
		super();
		this.speakersPower = speakersPower;
		this.numberOfspeakers = numberOfspeakers;
		this.frequencyResponse = frequencyResponse;
		this.connectionType = connectionType;
		this.headphoneType = headphoneType;
		this.microphone = microphone;
		this.workingTime = workingTime;
		this.wirelessTransmission = wirelessTransmission;
		this.devices = devices;
	}

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
