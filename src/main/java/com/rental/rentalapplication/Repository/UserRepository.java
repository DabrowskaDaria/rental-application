package com.rental.rentalapplication.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
