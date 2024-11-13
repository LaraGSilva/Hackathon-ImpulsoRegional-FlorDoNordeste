package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.controller;

import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint para login com email e senha
    @PostMapping("/login")
    public String loginWithEmail(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = authService.authenticateWithEmail(email, password);
        return isAuthenticated ? "Login com email e senha bem-sucedido" : "Falha no login com email e senha";
    }

    // Endpoint para login social
    @PostMapping("/social-login")
    public String loginWithSocial(@RequestParam String provider) {
        boolean isAuthenticated = authService.authenticateWithSocial(provider);
        return isAuthenticated ? "Login social bem-sucedido" : "Falha no login social";
    }
}
