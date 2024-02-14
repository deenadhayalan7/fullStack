package com.eweb.giftbackend.Service;

import com.eweb.giftbackend.dto.request.CartRequest;
// import com.eweb.giftbackend.dto.request.GiftRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.CartResponse;
// import com.eweb.giftbackend.dto.response.GiftResponse;
// import com.eweb.giftbackend.dto.response.GiftResponse;


public interface CartService {
    BasicResponse<CartResponse> getAllCart(); 
    CartResponse createCart(CartRequest request);
    BasicResponse<CartResponse> deletecart(String id);
    // CartResponse updateCart(String id,CartRequest request);

}