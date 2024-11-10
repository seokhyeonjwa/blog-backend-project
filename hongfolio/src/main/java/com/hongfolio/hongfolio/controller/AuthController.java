package com.hongfolio.hongfolio.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.hongfolio.hongfolio.JWTUtil.JWTUtil;
import com.hongfolio.hongfolio.repository.UserRepository;
import com.hongfolio.hongfolio.model.User;
import com.hongfolio.hongfolio.dto.UserLoginRequest;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody UserLoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

        if (user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(),user.get().getPassword())) {
            return jwtUtil.generateToken(user.get().getUsername());
        }else {
            throw new RuntimeException("아이디나 패스워드를 확인하세요.");
        }
    }
}
