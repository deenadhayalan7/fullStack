package com.eweb.giftbackend.Service;

import com.eweb.giftbackend.dto.request.CartRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.CartResponse;


public interface CartService {
    BasicResponse<CartResponse> getAllCart(); 
    CartResponse createCart(CartRequest request);
}