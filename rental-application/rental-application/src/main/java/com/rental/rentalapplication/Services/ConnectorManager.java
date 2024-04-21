package com.rental.rentalapplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.rentalapplication.Models.Connector;
import com.rental.rentalapplication.Repository.ConnectorRepository;

@Service
public class ConnectorManager {

	@Autowired
	ConnectorRepository connectorRepo;
	
	public List<Connector> showConnectors(){
		return connectorRepo.findAll();
	}
}
