package com.som.api.notification.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.som.api.notification.controller.EmailFeignClient;
import com.som.api.notification.dto.EmailRequest;
import com.som.api.notification.dto.EmailResponse;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    
	/*
	 * @Autowired private EmailFeignClient emailFeignClient;
	 */

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);


    @Value("${spring.mail.username}")
    private String mailFrom;

    //@Async
    public EmailResponse sendEmail(EmailRequest request) {
        log.info("Inside sendEmail ()");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getMailTo());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());
        message.setFrom(mailFrom); // your sender address

        log.info("Mail From: {}, Mail To: {}", mailFrom, request.getMailTo());
        log.info("before calling send ()");
        try {
            javaMailSender.send(message);
            log.info("After calling send ()");
            return new EmailResponse()
                .builder()
                .status("Success")
                .message("Email sent successfully")
                .recipient(request.getMailTo())
                .build();
        } catch (org.springframework.mail.MailException ex) {
            log.error("Failed to send email: {}", ex.getMessage(), ex);
            return new EmailResponse()
                .builder()
                .status("Failure")
                .message("Failed to send email: " + ex.getMessage())
                .recipient(request.getMailTo())
                .build();
        }
    }
    
    
    
}