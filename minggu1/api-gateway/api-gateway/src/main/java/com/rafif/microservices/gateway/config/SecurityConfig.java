package com.rafif.microservices.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final String[] freeResources = {"/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**",
            "/swagger-resources/**", "/api-docs/**", "/aggregate/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(freeResources)
                        .permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(outh2 -> outh2.jwt(Customizer.withDefaults()))
                .build();
    }
}
