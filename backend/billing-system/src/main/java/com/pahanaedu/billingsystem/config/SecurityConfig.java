package com.pahanaedu.billingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for Postman/testing
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Allow all endpoints without authentication
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)); // No session

        return http.build();
    }
}
