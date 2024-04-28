package com.rental.rentalapplication.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodOfPaymentRepository extends JpaRepository<MethodOfPayment, Integer>{

}
