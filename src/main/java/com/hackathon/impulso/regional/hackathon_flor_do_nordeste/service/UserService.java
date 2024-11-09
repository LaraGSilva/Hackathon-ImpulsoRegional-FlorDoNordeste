package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.model.User;
import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // Create
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read (all users)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read (single user)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}