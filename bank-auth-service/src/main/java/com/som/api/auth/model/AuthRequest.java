package com.som.api.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
	
	private String username;
	private String password;
	private String role; // e.g., "USER", "ADMIN"

}
