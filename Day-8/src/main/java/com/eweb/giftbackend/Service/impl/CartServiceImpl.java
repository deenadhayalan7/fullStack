package com.eweb.giftbackend.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eweb.giftbackend.Repository.CartRepository;
import com.eweb.giftbackend.Service.CartService;
import com.eweb.giftbackend.dto.request.CartRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.CartResponse;
import com.eweb.giftbackend.model.Cart;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepo;

    @Override
    public BasicResponse<CartResponse> getAllCart() 
    {
        List<Cart> carts = cartRepo.findAll();
        List<CartResponse> cartResponses = carts.stream()
            .map(cart -> CartResponse.builder()
                .amount(cart.getAmount())
                // .gift(cart.getGift())
                .build())
            .collect(Collectors.toList());
        return BasicResponse.<CartResponse>builder()
            .message("success!")
            .data(cartResponses)
            .build();
    }

    private final CartRepository cartRepository;
    @Override
    public CartResponse createCart(CartRequest request) {
        var cart= Cart.builder()
            .amount(request.getAmount())
            .build();
        cartRepository.save(cart);
        return CartResponse.builder()
            .message("Gift created successfully")
            .build();
    }

}