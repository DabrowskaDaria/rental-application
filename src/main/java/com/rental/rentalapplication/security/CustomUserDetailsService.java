package com.rental.rentalapplication.security;

import java.util.Collection;
import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Models.AccountType;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepo;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepo.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user.getAccountType()));	
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(AccountType accountType){
		
		return Collections.singletonList(new SimpleGrantedAuthority(accountType.getName()));
	}
	
}
