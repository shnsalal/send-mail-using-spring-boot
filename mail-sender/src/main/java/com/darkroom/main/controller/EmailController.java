package com.darkroom.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkroom.main.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@RequestMapping("/send-mail")
	public ResponseEntity<?> sendMail() {
		emailService.sendMail();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mail has been sent.");
	}
}
