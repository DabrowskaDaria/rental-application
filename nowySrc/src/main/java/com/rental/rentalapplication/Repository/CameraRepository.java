package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer>{

}
