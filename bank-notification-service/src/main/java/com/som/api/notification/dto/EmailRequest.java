package com.som.api.notification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailRequest {
	
	@NotBlank(message = "Recipient email address is required.")
	@NotNull(message = "Recipient email address cannot be null.")
	@Email(message = "Invalid email format.")
    private String mailTo;
	
	@NotBlank(message = "Email subject is required.")
	@NotNull(message = "Email subject cannot be null.")
    private String subject;
	
	@NotBlank(message = "Email body is required.")
	@NotNull(message = "Email body cannot be null.")
    private String body;

}
