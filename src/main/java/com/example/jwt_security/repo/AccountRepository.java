package com.example.jwt_security.repo;

import com.example.jwt_security.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByEmail(String email);
}
