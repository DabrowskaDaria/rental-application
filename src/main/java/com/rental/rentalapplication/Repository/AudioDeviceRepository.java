package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.AudioDevice;

@Repository
public interface AudioDeviceRepository extends JpaRepository<AudioDevice, Integer>{

}
