package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
