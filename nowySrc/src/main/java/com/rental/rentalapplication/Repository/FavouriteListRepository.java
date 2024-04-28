package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.FavouriteList;

@Repository
public interface FavouriteListRepository extends JpaRepository<FavouriteList, Integer>{

}
