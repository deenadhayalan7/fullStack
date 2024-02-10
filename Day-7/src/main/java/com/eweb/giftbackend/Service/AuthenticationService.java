package com.eweb.giftbackend.Service;

import com.eweb.giftbackend.dto.request.LoginRequest;
import com.eweb.giftbackend.dto.request.RegisterRequest;
import com.eweb.giftbackend.dto.response.LoginResponse;
import com.eweb.giftbackend.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);

   LoginResponse login(LoginRequest request);
}