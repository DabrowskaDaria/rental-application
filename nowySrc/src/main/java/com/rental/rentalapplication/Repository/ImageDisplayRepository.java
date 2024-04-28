package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.ImageDisplay;

import jakarta.transaction.Transactional;

@Repository
public interface ImageDisplayRepository extends JpaRepository<ImageDisplay, Integer> {

}
