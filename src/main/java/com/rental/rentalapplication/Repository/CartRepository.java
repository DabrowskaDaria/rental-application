package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
