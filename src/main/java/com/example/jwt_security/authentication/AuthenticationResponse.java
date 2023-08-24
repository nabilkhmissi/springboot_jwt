package com.example.jwt_security.authentication;

import com.example.jwt_security.models.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private Account user;
    private String access_token;
}
