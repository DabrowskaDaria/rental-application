package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.MethodOfReception;

@Repository
public interface MethodOfReceptionRepository extends JpaRepository<MethodOfReception, Integer>{

}
