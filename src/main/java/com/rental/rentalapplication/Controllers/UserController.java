package com.rental.rentalapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.rental.rentalapplication.DTO.UserPersonDto;

import com.rental.rentalapplication.Models.User;

import com.rental.rentalapplication.Services.UserManager;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/account")
public class UserController {

	@Autowired
	private UserManager userManager;
	
	@GetMapping("/create")
	public String showCreateAccountPage(Model model) {
		model.addAttribute("userPersonDto", new UserPersonDto() );
		return "account/createAccount";
	}
	
	@PostMapping("/create")
	public String createAccount(@Valid @ModelAttribute UserPersonDto userPersonDto, BindingResult result){
		if(result.hasErrors()) {
			return "redirect:/account/create";
		}
		userManager.addAccount(userPersonDto);
		return "redirect:/account/create";
	}
	
	
	@GetMapping("/add")
	public String showAddUserPage(Model model) {
		UserPersonDto userPersonDto= new UserPersonDto();
		model.addAttribute("userPersonDto", userPersonDto);
		return "/account/addUser";
	}
	
	@PostMapping("/add")
	public String addUser(@Valid @ModelAttribute UserPersonDto userPersonDto, @RequestParam("selectedOption") String selectedOption,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/account/addUser";
		}
		userManager.addUser(userPersonDto, selectedOption);
		return "redirect:/account/add";
	}
	

	@GetMapping("/showUsers")
	public String showUsers(Model model) {
		List <User> users=userManager.showUsers();
		model.addAttribute("users", users);
		return "account/showUsers";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam int id) {
		
		userManager.deleteUser(id);
		return "redirect:/account/showUsers";
	}
}
