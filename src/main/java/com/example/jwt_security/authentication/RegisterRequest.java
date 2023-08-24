package com.example.jwt_security.authentication;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
