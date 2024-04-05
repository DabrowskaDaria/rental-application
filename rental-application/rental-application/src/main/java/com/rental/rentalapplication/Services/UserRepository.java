package com.rental.rentalapplication.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
