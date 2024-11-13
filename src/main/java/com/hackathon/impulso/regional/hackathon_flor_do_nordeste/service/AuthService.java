package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.service;

import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.model.User;
import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Método para autenticar com e-mail e senha
    public boolean authenticateWithEmail(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Autenticação com e-mail e senha bem-sucedida.");
            return true;
        }
        System.out.println("Falha na autenticação com e-mail e senha.");
        return false;
    }

    // Método simulado de autenticação social
    public boolean authenticateWithSocial(String socialProvider) {
        // Em um projeto real, você integraria com APIs de provedores como Google, Facebook, etc.
        System.out.println("Autenticação social com o provedor " + socialProvider + " bem-sucedida.");
        return true;
    }
}
