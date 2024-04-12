package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.Models.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer > {

}
