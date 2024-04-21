package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer > {

}
