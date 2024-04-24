package com.rental.rentalapplication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.rentalapplication.Models.AccountType;

@Repository
public interface AccountTypeRepository  extends JpaRepository<AccountType, Integer>{
	AccountType findByName(String name);
}
