package com.example.jwt_security.service;

import com.example.jwt_security.authentication.RegisterRequest;
import com.example.jwt_security.models.Account;
import com.example.jwt_security.repo.AccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account save(RegisterRequest request) {
        Account user = new Account();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return accountRepository.save(user);
    }

@PostConstruct
    public void initUser(){
        Account entity = new Account();
        entity.setName("user");
        entity.setEmail("user@mail.com");
        entity.setPassword(passwordEncoder.encode("user"));
        accountRepository.save(entity);
    }
}
