package com.rental.rentalapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepo;
	
	@GetMapping("/categories")
	public String showCategories(Model model) {
		List<Category> categories= categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return"addDevice";
	}
}
