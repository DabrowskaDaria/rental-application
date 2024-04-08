package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
