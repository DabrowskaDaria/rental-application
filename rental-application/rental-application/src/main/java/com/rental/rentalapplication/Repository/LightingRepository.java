package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Lighting;

@Repository
public interface LightingRepository extends JpaRepository<Lighting, Integer>{

}
