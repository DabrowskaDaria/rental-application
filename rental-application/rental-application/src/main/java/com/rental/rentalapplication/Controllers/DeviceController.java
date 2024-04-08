package com.rental.rentalapplication.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rental.rentalapplication.DTO.DeviceDto;
import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Services.DeviceManager;

@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	DeviceManager deviceManager;
	
	@GetMapping("/add")
	public String showcreateDevicePage(Model model) {
		model.addAttribute("deviceDto", new DeviceDto() );
		return "device/addDevice";
	}
	
	@PostMapping("/add")
	public String addDevice(@ModelAttribute DeviceDto deviceDto){
		deviceManager.addDevice(deviceDto);
		return "redirect:/device/add";
	}
	
	/*
	@GetMapping("/addDevice")
	public String showcreateDevicePage(Model model) {
		model.addAttribute("addDeviceForm", new AddDeviceForm() );
		return "device/addDevice";
	}
	
	@PostMapping("/addDevice")
	public String addDevice(@ModelAttribute("addDeviceForm") AddDeviceForm addDeviceForm) {
		String category=addDeviceForm.getCategory();
		Map<String, String> technicalData=addDeviceForm.getTechnicalData();
		System.out.println(category);
		return"redirect:/device/addDevice";
	}
	*/
}