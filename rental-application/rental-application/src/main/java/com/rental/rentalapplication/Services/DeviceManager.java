package com.rental.rentalapplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.rentalapplication.DTO.DeviceDto;
import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Models.AudioDevice;
import com.rental.rentalapplication.Models.Camera;
import com.rental.rentalapplication.Models.Computer;
import com.rental.rentalapplication.Models.Connector;
import com.rental.rentalapplication.Models.Device;
import com.rental.rentalapplication.Models.DeviceConnector;
import com.rental.rentalapplication.Models.ImageDisplay;
import com.rental.rentalapplication.Models.Lighting;
import com.rental.rentalapplication.Models.Person;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.AudioDeviceRepository;
import com.rental.rentalapplication.Repository.CameraRepository;
import com.rental.rentalapplication.Repository.ComputerRepository;
import com.rental.rentalapplication.Repository.ConnectorRepository;
import com.rental.rentalapplication.Repository.DeviceRepository;
import com.rental.rentalapplication.Repository.ImageDisplayRepository;
import com.rental.rentalapplication.Repository.LightingRepository;

@Service
public class DeviceManager {
	@Autowired
	private ImageDisplayRepository displayRepo;
	
	@Autowired
	private AudioDeviceRepository audioRepo;
	
	@Autowired
	private CameraRepository cameraRepo;
	
	@Autowired
	private LightingRepository lightingRepo;
	
	@Autowired
	private ComputerRepository computerRepo;
	
	@Autowired
	private DeviceRepository deviceRepo;

	
	
	public void addDevice(@ModelAttribute DeviceDto deviceDto) {
		
		
			if(deviceDto.getCategory().getName().equals("telewizor")) {
				ImageDisplay imageDisplay= new ImageDisplay(deviceDto.getScreenResolution(),deviceDto.getScreenSize(),deviceDto.getRefreshRate());
				displayRepo.save(imageDisplay);
				Device device = new Device(deviceDto.getCategory(), null, imageDisplay, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}
			
			else if(deviceDto.getCategory().getName().equals("laptop")) {
				Computer computer= new Computer(deviceDto.getDisplay(), deviceDto.getProcesor(), deviceDto.getDrive(), deviceDto.getRam(), deviceDto.getGraphicsCard(), deviceDto.getOperatingSystem());
				computerRepo.save(computer);
				Device device = new Device(deviceDto.getCategory(), computer, null, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("monitor")) {
				ImageDisplay imageDisplay= new ImageDisplay(deviceDto.getScreenResolution(),deviceDto.getScreenSize(),deviceDto.getRefreshRate());
				displayRepo.save(imageDisplay);
				Device device = new Device(deviceDto.getCategory(), null, imageDisplay, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("nagłośnienie")) {
				AudioDevice audioDevice= new AudioDevice(deviceDto.getSpeakersPower(), deviceDto.getNumberOfspeakers());
				audioRepo.save(audioDevice);
				Device device = new Device(deviceDto.getCategory(), null, null, null, audioDevice, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("projektor multimedialny")){
				ImageDisplay imageDisplay= new ImageDisplay(deviceDto.getMatrixType(),deviceDto.getLampPower(),deviceDto.getScreenResolution());
				displayRepo.save(imageDisplay);
				Device device = new Device(deviceDto.getCategory(), null, imageDisplay, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("ekran")) {
				ImageDisplay imageDisplay= new ImageDisplay(deviceDto.getScreenFormat(),deviceDto.getScreenSize(),deviceDto.getActiveSurface());
				displayRepo.save(imageDisplay);
				Device device = new Device(deviceDto.getCategory(), null, imageDisplay, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("oświetlenie")) {
				Lighting lighting= new Lighting(deviceDto.getLightingColor(),deviceDto.getPowerConsumption(), deviceDto.getLampPower(), deviceDto.getDeviceSize());
				lightingRepo.save(lighting);
				Device device = new Device(deviceDto.getCategory(), null, null, null, null, lighting, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("słuchawki")){
				AudioDevice audioDevice= new AudioDevice(deviceDto.getHeadphoneType(), deviceDto.isMicrophone(),deviceDto.getWorkingTime(),deviceDto.isWirelessTransmission());
				audioRepo.save(audioDevice);
				Device device = new Device(deviceDto.getCategory(), null, null, null, audioDevice, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("tablet")) {
				Computer computer= new Computer(deviceDto.getDisplay(), deviceDto.getProcesor(), deviceDto.getDrive(), deviceDto.getRam(), deviceDto.getOperatingSystem());
				computerRepo.save(computer);
				Device device = new Device(deviceDto.getCategory(), computer, null, null, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("kamera")) {
				Camera camera= new Camera(deviceDto.getResolution(),deviceDto.isImageStabilization(), deviceDto.isOpticalZoom());
				cameraRepo.save(camera);
				Device device = new Device(deviceDto.getCategory(), null, null, camera, null, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}else if (deviceDto.getCategory().getName().equals("mikrofon")) {
				AudioDevice audioDevice= new AudioDevice(deviceDto.getFrequencyResponse(),deviceDto.getMicrophoneType(),deviceDto.isWirelessTransmission());
				audioRepo.save(audioDevice);
				Device device = new Device(deviceDto.getCategory(), null, null, null, audioDevice, null, deviceDto.getName(), deviceDto.getPrice(), deviceDto.getDeposit(), deviceDto.getDescription());
				for ( Connector connector : deviceDto.getConnectors()) {
					device.addConnector(connector);
				}
				deviceRepo.save(device);
			}
		
		}
	
	public List<Device> showDevices(){
		return deviceRepo.findAll();
	}
		
	public void deleteDevice(@PathVariable Integer id) {
		try {
			Device device=deviceRepo.findById(id).get();
			deviceRepo.delete(device);	
		}catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}}
	
	public Device getDevice(Integer id) {
		return deviceRepo.findById(id).get();
	}
	
	public Device modifyDevice(@ModelAttribute DeviceDto deviceDto,@PathVariable Integer id)	{
		Device device=deviceRepo.findById(id).get();
		deviceDto.setName(device.getName());
		deviceDto.setPrice(device.getPrice());
		return device;
	}
}
	

