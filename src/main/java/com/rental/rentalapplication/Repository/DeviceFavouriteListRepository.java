package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.DeviceFavouriteList;

@Repository
public interface DeviceFavouriteListRepository  extends JpaRepository<DeviceFavouriteList, Integer>{

}
