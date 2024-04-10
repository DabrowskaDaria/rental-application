package com.rental.rentalapplication.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="audio_devices")
public class AudioDevice {
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

	public int getNumberOfspeakers() {
		return numberOfspeakers;
	}

	public void setNumberOfspeakers(int numberOfspeakers) {
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

	public boolean isMicrophone() {
		return microphone;
	}

	public void setMicrophone(boolean microphone) {
		this.microphone = microphone;
	}

	public int getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
	}

	public boolean isWirelessTransmission() {
		return wirelessTransmission;
	}

	public void setWirelessTransmission(boolean wirelessTransmission) {
		this.wirelessTransmission = wirelessTransmission;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public AudioDevice(String speakersPower, int numberOfspeakers, String frequencyResponse, String connectionType,
			String headphoneType, boolean microphone, int workingTime, boolean wirelessTransmission,
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="speakers_power")
	private String speakersPower;

	@Column(name="number_of_speakers")
	private int numberOfspeakers;
	
	@Column(name="frequency_response")
	private String frequencyResponse;
	
	@Column(name="microphone_type")
	private String microphoneType; 
	
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
