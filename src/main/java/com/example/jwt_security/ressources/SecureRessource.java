package com.example.jwt_security.ressources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secure")
public class SecureRessource {

    @GetMapping("")
    public String greeting(){
        return "secure ressources";
    }
}
