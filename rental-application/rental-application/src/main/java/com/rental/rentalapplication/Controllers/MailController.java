package com.rental.rentalapplication.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rental.rentalapplication.Services.MailService;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	public MailController(MailService mailService) {
		super();
		this.mailService = mailService;
	}

	private MailService mailService;
	
	@GetMapping("/sendMail")
	public String sendEmail() {
		mailService.sendEmail("<darusia43d@gmail.com>","Test", "Wiadomość testowa");
		return "redirect:/homePage/show";
	}
}
