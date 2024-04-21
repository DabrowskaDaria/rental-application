package com.rental.rentalapplication.Controllers;

import java.util.List;


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
import com.rental.rentalapplication.Repository.CartRepository;
import com.rental.rentalapplication.Services.CategoryManager;
import com.rental.rentalapplication.Services.ConnectorManager;
import com.rental.rentalapplication.Services.DeviceManager;



@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	DeviceManager deviceManager;
	
	@Autowired
	CategoryManager categoryManager;
	
	@Autowired
	ConnectorManager connectorManager;
	
	@Autowired
	CartRepository cartRepo;

	
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
	public String modifyDevice(@ModelAttribute DeviceDto deviceDto, @PathVariable Integer id) {
		deviceManager.modifyDevice(deviceDto,id);
		return "redirect:/device/modify";
	}
	
	
}
