package com.rental.rentalapplication.Controllers;



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
import com.rental.rentalapplication.Services.UserManager;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserManager userManager;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserPersonDto userPersonDto= new UserPersonDto();
		model.addAttribute("userPersonDto", userPersonDto);
		return "/account/createAccount";
	}
	

	@PostMapping("/register/save")
	public String register(@Valid @ModelAttribute UserPersonDto userPersonDto, BindingResult result){
		if(result.hasErrors()) {
			return "/account/createAccount";
		}
		userManager.addAccount(userPersonDto);
		return "redirect:/register/success";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		return"/login/login";
	}
	
	@GetMapping("/register/success")
	public String showLoginSuccess(Model model) {
		
		return "/register/success";
	}
}
