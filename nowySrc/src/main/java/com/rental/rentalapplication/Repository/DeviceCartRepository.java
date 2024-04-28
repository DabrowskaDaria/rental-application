package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.DeviceCart;

@Repository
public interface DeviceCartRepository extends JpaRepository<DeviceCart, Integer>{

}
