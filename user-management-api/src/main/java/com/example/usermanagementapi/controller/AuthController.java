package com.example.usermanagementapi.controller;

import com.example.usermanagementapi.model.LoginRequest;
import com.example.usermanagementapi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        String token = authService.login(request);

        if (token == null) {
            return ResponseEntity.status(401)
                    .body("Invalid username or password");
        }

        return ResponseEntity.ok(new LoginResponse("Login successful", token));
    }
}

class LoginResponse {
    private String message;
    private String token;

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters
    public String getMessage() { return message; }
    public String getToken() { return token; }
}
