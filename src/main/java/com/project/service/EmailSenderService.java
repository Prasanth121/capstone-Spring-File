package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void emailForOwnerToUser(String toEmail,
			String body,
			String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("havenlife@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Send...");
	}

	public void emailForUsertoOwner(String fromEmail, String toEmail,
			String body,
			String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(fromEmail);
		System.out.println(fromEmail);
		message.setTo(toEmail);
		System.out.println(toEmail);
		message.setText(body);
		System.out.println(subject);
		System.out.println(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Send...");
	}
}
