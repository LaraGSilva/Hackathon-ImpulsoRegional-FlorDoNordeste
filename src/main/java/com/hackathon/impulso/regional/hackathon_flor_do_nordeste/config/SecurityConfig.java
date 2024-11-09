package com.hackathon.impulso.regional.hackathon_flor_do_nordeste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/auth/login", "/api/auth/register", "/api/auth/social-login").permitAll()  // Permitir registro e login social
                .anyRequest().authenticated()  // Requerer autenticação para outras rotas
            .and()
            .formLogin() // Configuração de login com formulário
                .loginPage("/login")
                .permitAll()
            .and()
            .oauth2Login() // Configuração para login social
                .loginPage("/login")
                .permitAll();
    }
}