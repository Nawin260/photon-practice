package com.example.kafka_demo.userAuth;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String role;

}
