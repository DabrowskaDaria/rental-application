package com.rental.rentalapplication.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Models.AccountType;
import com.rental.rentalapplication.Models.Person;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.AccountTypeRepository;
import com.rental.rentalapplication.Repository.PersonRepository;
import com.rental.rentalapplication.Repository.UserRepository;



@Service
public class UserManager {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PersonRepository personRepo; 

	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@Autowired
	private AccountTypeRepository accountTypeRepo;
	
	public void addAccount(@ModelAttribute UserPersonDto userPersonDto) {
		User user= new User(userPersonDto.getEmail(), passwordEncoder.encode(userPersonDto.getPassword()));
		AccountType accountType=accountTypeRepo.findByName("Użytkownik");
		user.setAccountType(accountType);
		Person person= new Person(userPersonDto.getFirstName(), userPersonDto.getSurname(), userPersonDto.getPhoneNumber());
		userRepo.save(user);
		person.setUser(user);
		personRepo.save(person);
	}
	
	public void addUser(@ModelAttribute UserPersonDto userPersonDto, String accountType) {
		User user= new User(userPersonDto.getEmail(), userPersonDto.getPassword());
		AccountType accountType1=new AccountType();
		accountType1.setName(accountType);
		user.setAccountType(accountType1);
		userRepo.save(user);
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
	
	public List<AccountType> getAllAccountTypes(){
		return accountTypeRepo.findAll();
	}
}
