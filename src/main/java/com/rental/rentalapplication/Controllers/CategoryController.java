package com.rental.rentalapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Repository.CategoryRepository;
import com.rental.rentalapplication.Services.CategoryManager;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	CategoryManager categoryManager;
	@GetMapping("/categories")
	public String showCategories(Model model) {
		List<Category> categories= categoryManager.showCategory();
		model.addAttribute("categories", categories);
		return"addDevice";
	}
}
