package com.example.kafka_demo.userAuth;

import com.example.kafka_demo.email_notification.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthController(UserService service, AuthenticationManager authenticationManager, EmailService emailService) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        return ResponseEntity.ok("Login Successful");
    }

    @PostMapping("/test-email")
    public String testEmail() {
        System.out.println("API-Triggered");
        emailService.sendEmail(
                "naveendevarinti260@gmail.com",
                "Spring Security Test",
                "Congratulations! Email is working."
        );

        return "Email Sent";
    }
}
