package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rental.rentalapplication.Models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
