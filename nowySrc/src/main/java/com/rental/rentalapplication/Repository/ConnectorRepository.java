package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.Connector;

@Repository
public interface ConnectorRepository extends JpaRepository<Connector, Integer>{

}
