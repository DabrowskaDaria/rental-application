package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rental.rentalapplication.Models.Device;

@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
