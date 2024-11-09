package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); 
}
