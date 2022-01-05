package com.project;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.project.service.EmailSenderService;

@SpringBootApplication
public class RentAPlaceProjectApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(RentAPlaceProjectApplication.class, args);
	}
	

}
