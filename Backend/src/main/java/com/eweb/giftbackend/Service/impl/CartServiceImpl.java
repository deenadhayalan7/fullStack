package com.eweb.giftbackend.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eweb.giftbackend.Repository.CartRepository;
import com.eweb.giftbackend.Service.CartService;
import com.eweb.giftbackend.dto.request.CartRequest;
import com.eweb.giftbackend.dto.request.GiftRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.CartResponse;
import com.eweb.giftbackend.dto.response.GiftResponse;
// import com.eweb.giftbackend.dto.response.GiftResponse;
import com.eweb.giftbackend.model.Cart;
import com.eweb.giftbackend.model.Gift;

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
    // @Override
    //     public CartResponse updateCart(String cartid, CartRequest request) {
    //         if (cartRepository.existsById(cartid)) {
    //             Gift existingCart = cartRepository.findById(cartid).orElse(null);
    //             if (existingCart != null) {
    //                 existingCart.setGift_name(request.getCart_id());
    //                 existingCart.setGift_price(request.getGift_price());
    //                 cartRepository.save(existingCart);
    //                 return CartResponse.builder()
    //                     .message("Gift updated successfully")
    //                     .build();
    //             } else {
    //                 return GiftResponse.builder()
    //                     .message("Failed to update gift. Gift not found with ID: " + giftId)
    //                     .build();
    //             }
        //     } else {
        //         return GiftResponse.builder()
        //             .message("Failed to update gift. Gift not found with ID: " + giftId)
        //             .build();
        //     }
        // }
	@Override
        public BasicResponse<CartResponse> deletecart(String Cartid) {
            if (cartRepository.existsById(Cartid)) {
                cartRepository.deleteById(Cartid);
                return BasicResponse.<CartResponse>builder()
                    .message("Gift deleted successfully")
                    .build();
            } else {
                return BasicResponse.<CartResponse>builder()
                    .message("Gift not found with ID: " + Cartid)
                    .build();
            }
        }

}