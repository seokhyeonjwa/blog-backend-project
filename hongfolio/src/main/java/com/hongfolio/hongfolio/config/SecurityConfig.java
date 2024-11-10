package com.hongfolio.hongfolio.config;

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
            .csrf(csrf -> csrf.disable()) // 최신 방식으로 CSRF 비활성화
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/auth/**", "/error", "/**").permitAll() // 인증 없이 접근 가능
                .anyRequest().authenticated() // 다른 모든 요청은 인증 필요
            );

        return http.build();
    }
}
