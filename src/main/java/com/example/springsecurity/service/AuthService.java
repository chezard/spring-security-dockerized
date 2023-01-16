package com.example.springsecurity.service;

import com.example.springsecurity.dto.LoginRequest;
import com.example.springsecurity.dto.TokenResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    public AuthService(AuthenticationManager authenticationManager,
                       UserService userService,
                       TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
    }


    public TokenResponseDto login(LoginRequest loginRequest) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        return new TokenResponseDto(tokenService.generateToken(auth),
                userService.findByUsername(loginRequest.getUsername()));
    }

}
