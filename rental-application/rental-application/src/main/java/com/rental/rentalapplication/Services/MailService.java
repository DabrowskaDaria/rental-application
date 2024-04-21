package com.rental.rentalapplication.Services;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	public MailService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}


	private JavaMailSender javaMailSender;
	

	public void sendEmail(String to, String subject, String content) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("<D.Dabrowska@wit.edu.pl>");
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
	}
}
