package com.rental.rentalapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.rental.rentalapplication.Services.PersonRepository;
import com.rental.rentalapplication.Services.UserRepository;
import com.rental.rentalapplication.models.Person;
import com.rental.rentalapplication.models.PersonDto;
import com.rental.rentalapplication.models.User;
import com.rental.rentalapplication.models.UserDto;



@Controller
@RequestMapping("/account")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PersonRepository personRepo;
	
	@GetMapping("/create")
	public String showCreateAccountPage(Model model) {
		UserDto userDto=new UserDto();
		model.addAttribute("userDto", userDto);
		PersonDto personDto=new PersonDto();
		model.addAttribute("personDto", personDto);
		return "createAccount";
	}
	
	@PostMapping("/create")
	public String createAccount(@ModelAttribute UserDto userDto, @ModelAttribute PersonDto personDto){
		User user= new User(userDto.getEmail(), userDto.getPassword());
		Person person= new Person(personDto.getFirstName(), personDto.getSurname(), personDto.getPhoneNumber());
		userRepo.save(user);
		personRepo.save(person);
		return "redirect:/create";
	}
}
