package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita o CSRF para simplificar o desenvolvimento
            .authorizeRequests(authorize -> authorize
                .requestMatchers("/api/auth/login", "/api/auth/register", "/api/auth/social-login").permitAll() // Permite acesso sem autenticação a estas rotas
                .anyRequest().authenticated() // Exige autenticação para qualquer outra rota
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll() // Permite acesso à página de login para todos
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login") // Configura o login social na mesma página de login
                .permitAll()
            );

        return http.build();
    }
}
