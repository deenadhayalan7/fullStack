package com.eweb.giftbackend.Service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.eweb.giftbackend.Repository.UserRepository;
import com.eweb.giftbackend.Service.UserService;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.UserResponse;
import com.eweb.giftbackend.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
   
    @Override
    public BasicResponse<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user->UserResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .role(user.getRole())
        .image(user.getImage())
        .phoneNumber(user.getPhoneNumber())
        .build())
        .collect(Collectors.toList()); 
        return BasicResponse.<UserResponse>builder()
        .message("User data fetched successfully!")
          .data(userResponses)
          .build();
        
    }

}