package com.rental.rentalapplication.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Models.Person;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.PersonRepository;
import com.rental.rentalapplication.Repository.UserRepository;



@Service
public class UserManager {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PersonRepository personRepo; 

	
	public void addAccount(@ModelAttribute UserPersonDto userPersonDto) {
		User user= new User(userPersonDto.getEmail(), userPersonDto.getPassword());
		user.setAccountType("USER");
		Person person= new Person(userPersonDto.getFirstName(), userPersonDto.getSurname(), userPersonDto.getPhoneNumber());
		userRepo.save(user);
		person.setUser(user);
		personRepo.save(person);
	}
	
	public void addUser(@ModelAttribute UserPersonDto userPersonDto, String selectedOption) {
		User user= new User(userPersonDto.getEmail(), userPersonDto.getPassword());
		user.setAccountType(selectedOption);
		Person person= new Person(userPersonDto.getFirstName(), userPersonDto.getSurname(), userPersonDto.getPhoneNumber());
		userRepo.save(user);
		person.setUser(user);
		personRepo.save(person);
	}
	
	public List<User> showUsers() {
		
		List<User> users= userRepo.findAll();
		return users;
	}
	
	public void deleteUser(@PathVariable Integer id) {
		
		try {
			User user=userRepo.findById(id).get();
			userRepo.delete(user);
			
		}catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
	
	public void editData(@ModelAttribute UserPersonDto userPersonDto,@RequestParam int id) {
		Person person=personRepo.findById(id).get();
		person.setFirstName(userPersonDto.getFirstName());
		person.setSurname(userPersonDto.getSurname());
		person.setPhoneNumber(userPersonDto.getPhoneNumber());
		personRepo.save(person);
	}
	
	public User getUser(Integer id) {
		return userRepo.findById(id).get();
	}
	
}
