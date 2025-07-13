package com.som.api.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.som.api.notification.dto.EmailRequest;
import com.som.api.notification.dto.EmailResponse;
import com.som.api.notification.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notification/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send")
	public EmailResponse sendEmail(@Valid @RequestBody EmailRequest request) {
		return emailService.sendEmail(request);
	}

}
