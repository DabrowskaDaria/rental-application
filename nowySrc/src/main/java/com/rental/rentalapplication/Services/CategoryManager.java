package com.rental.rentalapplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Repository.CategoryRepository;

@Service
public class CategoryManager {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> showCategory(){
		return categoryRepository.findAll();
	}
}
