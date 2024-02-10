package com.eweb.giftbackend.Service.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eweb.giftbackend.Repository.UserRepository;
import com.eweb.giftbackend.Service.AuthenticationService;
import com.eweb.giftbackend.dto.request.LoginRequest;
import com.eweb.giftbackend.dto.request.RegisterRequest;
import com.eweb.giftbackend.dto.response.LoginResponse;
import com.eweb.giftbackend.dto.response.RegisterResponse;
import com.eweb.giftbackend.enumerated.Role;
import com.eweb.giftbackend.model.User;
import com.eweb.giftbackend.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Override
    public RegisterResponse register(RegisterRequest request){
        Optional<User> isUserExists=userRepository.findByEmail(request.getEmail());
        if(isUserExists.isPresent()){
            return RegisterResponse.builder().message("User with mail id" + request.getEmail() + "is already exists!")
            .build();
        }
        var user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
                userRepository.save(user);
        // throw new UnsupportedOperationException("Unimplemented method 'register'");
        return RegisterResponse.builder()
        .message("User create successfully!")
        .build();
   
    }
    @Override
    public LoginResponse login(LoginRequest request) {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
       var user=userRepository.findByEmail(request.getEmail()).orElseThrow();
       String token=jwtUtil.generateToken(user);
       return LoginResponse.builder().message("User logged in successfully")
               .token(token)
               .build();
        
        
   
    }
    
}