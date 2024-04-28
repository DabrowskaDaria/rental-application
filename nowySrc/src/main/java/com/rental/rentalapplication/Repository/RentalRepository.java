package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Rental;

@Repository
public interface RentalRepository  extends JpaRepository<Rental, Integer>{

}
