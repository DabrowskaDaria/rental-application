package com.rental.rentalapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rentalapplication.Models.Connector;

public interface ConnectorRepository extends JpaRepository<Connector, Integer>{

}