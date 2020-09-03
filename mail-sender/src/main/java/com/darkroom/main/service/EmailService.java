package com.darkroom.main.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public void sendMail() throws MailException {
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo("receiver@gmail.com");
			mail.setFrom("sender@gmail.com");
			mail.setSubject("Sending mail");
			mail.setText("Your have got a new mail.");
			javaMailSender.send(mail);
		} catch(MailException e) {
			logger.info("Check info: " + e);
		}
	}
}
