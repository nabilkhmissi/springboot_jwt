package com.example.jwt_security.authentication;

import com.example.jwt_security.models.Account;
import com.example.jwt_security.repo.AccountRepository;
import com.example.jwt_security.security.JwtService;
import com.example.jwt_security.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountService accountService;
    private final AccountRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        Account user = accountService.save(request);
        return "Account created successfully";
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Account user = repository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("invalid email/password");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .user(user)
                .access_token(jwtToken)
                .build();
    }
}