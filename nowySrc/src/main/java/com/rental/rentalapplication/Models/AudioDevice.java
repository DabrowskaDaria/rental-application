package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="audio_devices")
public class AudioDevice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="speakers_power", nullable = true)
	private String speakersPower;

	@Column(name="number_of_speakers", nullable = true)
	private Integer numberOfspeakers;
	
	@Column(name="frequency_response", nullable = true)
	private String frequencyResponse;
	
	@Column(name="microphone_type", nullable = true)
	private String microphoneType; 
	
	@Column(name="headphone_type", nullable = true)
	private String headphoneType; 
	
	@Column(nullable = true)
	private Boolean microphone;
	
	@Column(name="working_time", nullable = true)
	private Integer workingTime;
	
	@Column(name="wireless_transmission", nullable = true)
	private Boolean wirelessTransmission;
	
	@OneToMany(mappedBy = "audioDevice", cascade = CascadeType.ALL)
	private List<Device> devices= new ArrayList<Device>();
	
	
	public AudioDevice(String frequencyResponse, String microphoneType, Boolean wirelessTransmission) {
		super();
		this.frequencyResponse = frequencyResponse;
		this.microphoneType = microphoneType;
		this.wirelessTransmission = wirelessTransmission;
	}

	public AudioDevice() {
		super();
	}

	public AudioDevice(String headphoneType, Boolean microphone, Integer workingTime, Boolean wirelessTransmission) {
		super();
		this.headphoneType = headphoneType;
		this.microphone = microphone;
		this.workingTime = workingTime;
		this.wirelessTransmission = wirelessTransmission;
	}

	public AudioDevice(String speakersPower, Integer numberOfspeakers) {
		super();
		this.speakersPower = speakersPower;
		this.numberOfspeakers = numberOfspeakers;
	}

	public AudioDevice(String speakersPower, Integer numberOfspeakers, String frequencyResponse, String connectionType,
			String headphoneType, Boolean microphone, Integer workingTime, Boolean wirelessTransmission,
			List<Device> devices) {
		super();
		this.speakersPower = speakersPower;
		this.numberOfspeakers = numberOfspeakers;
		this.frequencyResponse = frequencyResponse;
		this.microphoneType = connectionType;
		this.headphoneType = headphoneType;
		this.microphone = microphone;
		this.workingTime = workingTime;
		this.wirelessTransmission = wirelessTransmission;
		this.devices = devices;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpeakersPower() {
		return speakersPower;
	}

	public void setSpeakersPower(String speakersPower) {
		this.speakersPower = speakersPower;
	}

	public Integer getNumberOfspeakers() {
		return numberOfspeakers;
	}

	public void setNumberOfspeakers(Integer numberOfspeakers) {
		this.numberOfspeakers = numberOfspeakers;
	}

	public String getFrequencyResponse() {
		return frequencyResponse;
	}

	public void setFrequencyResponse(String frequencyResponse) {
		this.frequencyResponse = frequencyResponse;
	}

	public String getMicrophoneType() {
		return microphoneType;
	}

	public void setMicrophoneType(String microphoneType) {
		this.microphoneType = microphoneType;
	}

	public String getHeadphoneType() {
		return headphoneType;
	}

	public void setHeadphoneType(String headphoneType) {
		this.headphoneType = headphoneType;
	}

	public Boolean isMicrophone() {
		return microphone;
	}

	public void setMicrophone(Boolean microphone) {
		this.microphone = microphone;
	}

	public Integer getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(Integer workingTime) {
		this.workingTime = workingTime;
	}

	public Boolean isWirelessTransmission() {
		return wirelessTransmission;
	}

	public void setWirelessTransmission(Boolean wirelessTransmission) {
		this.wirelessTransmission = wirelessTransmission;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	

	
}
