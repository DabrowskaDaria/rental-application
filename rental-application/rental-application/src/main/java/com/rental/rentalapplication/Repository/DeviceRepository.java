package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.Models.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
