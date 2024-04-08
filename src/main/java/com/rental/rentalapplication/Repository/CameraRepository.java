package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.Models.Camera;

public interface CameraRepository extends JpaRepository<Camera, Integer>{

}
