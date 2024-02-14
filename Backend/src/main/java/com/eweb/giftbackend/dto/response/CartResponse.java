package com.eweb.giftbackend.dto.response;

import com.eweb.giftbackend.model.Gift;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class CartResponse {
    private String id;
    private String message;
    private int amount;
    private Gift gift;
}
