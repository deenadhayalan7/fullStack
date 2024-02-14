package com.eweb.giftbackend.dto.request;


import com.eweb.giftbackend.model.Gift;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private String id;
    private int amount;
    // private Gift gift;

}
