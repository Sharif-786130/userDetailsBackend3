package com.example.usermanagementapi.service;

import com.example.usermanagementapi.model.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Simple hardcoded login for POC
	public String login(LoginRequest request) {
	    if ("sharif@gmail.com".equals(request.getEmail()) &&
	        "sharif123".equals(request.getPassword())) {

	        return "fake-jwt-token-123456";
	    }
	    return null;
	}
}
