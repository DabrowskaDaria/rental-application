package com.rental.rentalapplication.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;



import com.rental.rentalapplication.DTO.DeviceDto;
import com.rental.rentalapplication.Models.Cart;
import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Models.Connector;
import com.rental.rentalapplication.Models.Device;
import com.rental.rentalapplication.Models.DeviceCart;
import com.rental.rentalapplication.Models.ImageDisplay;
import com.rental.rentalapplication.Repository.CartRepository;
import com.rental.rentalapplication.Repository.DeviceRepository;
import com.rental.rentalapplication.Repository.ImageDisplayRepository;
import com.rental.rentalapplication.Services.CategoryManager;
import com.rental.rentalapplication.Services.ConnectorManager;
import com.rental.rentalapplication.Services.DeviceManager;

@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	private DeviceManager deviceManager;
	
	@Autowired
	private CategoryManager categoryManager;
	
	@Autowired
	private ConnectorManager connectorManager;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private DeviceRepository deviceRepo;
	
	@Autowired
	private ImageDisplayRepository imageDisplayRepo;

	@GetMapping("/add")
	public String showcreateDevicePage(Model model) {
		List<Category> categories= categoryManager.showCategory();
		List<Connector> connectors=connectorManager.showConnectors();
	
		model.addAttribute("deviceDto", new DeviceDto() );
		model.addAttribute("categories", categories);
		model.addAttribute("connectors", connectors);
		
		return "device/addDevice";
	}
	
	@PostMapping("/add")
	public String addDevice(@ModelAttribute DeviceDto deviceDto){
		deviceManager.addDevice(deviceDto);
		
		return "redirect:/device/add";
	}
	
	@GetMapping("/showDevices")
	public String showDevices(Model model) {
		List <Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "device/showDevices";
	}
	
	@PostMapping("/deleteDevice/{id}/delete")
	public String deleteDevice(@PathVariable("id") Integer id) {
		deviceManager.deleteDevice(id);
		return"redirect:/device/showDevices";
	}
	
	@GetMapping("/modify/{id}")
	public String showModifyDeviceForm(@PathVariable ("id") Integer id, Model model) {
		Device device=deviceManager.getDevice(id);
		model.addAttribute("device", device);
		
		return "device/modifyDevice";
	}
	
	@PostMapping("/modify/{id}")
	public String modifyDevice(@PathVariable Integer id,@ModelAttribute DeviceDto deviceDto ) {
		Device device=deviceRepo.findById(id).get();
		Integer imageDisplayId=device.getImageDisplay().getId();
		ImageDisplay imageDisplay= imageDisplayRepo.findById(imageDisplayId).get();
		System.out.println(imageDisplayId);
		Map<String,String> map=deviceDto.getTechnicalDetails();
		for(Map.Entry<String, String> entry: map.entrySet()) {
			String key=entry.getKey();
			String value= entry.getValue();
			System.out.println("Klucz: "+ key+" Wartośc: "+value);
		} 
		imageDisplay.setScreenSize(deviceDto.getScreenSize());
		imageDisplay.setScreenResolution(deviceDto.getScreenResolution());
		imageDisplay.setRefreshRate(deviceDto.getRefreshRate());
		device.setName(deviceDto.getName());
		device.setPrice(deviceDto.getPrice());
		device.setDeposit(deviceDto.getDeposit());
		device.setDescription(deviceDto.getDescription());
		imageDisplayRepo.save(imageDisplay);
		deviceRepo.save(device);
		return "redirect:/device/showDevices";
	}
	
}
