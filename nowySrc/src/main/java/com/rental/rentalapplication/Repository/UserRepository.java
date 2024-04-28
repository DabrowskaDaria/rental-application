package com.rental.rentalapplication.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		User findByEmail(String email);
		Boolean existsByEmail(String email);
}
