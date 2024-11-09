package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    // Endpoint de login simples
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Login bem-sucedido!";
    }

    // Endpoint para login social (ex: Google)
    @GetMapping("/social-login")
    public String socialLogin() {
        return "Login via social!";
    }
}
