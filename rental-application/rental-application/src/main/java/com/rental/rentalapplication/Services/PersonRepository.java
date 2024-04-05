package com.rental.rentalapplication.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
