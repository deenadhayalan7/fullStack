package com.eweb.giftbackend.dto.response;

// import java.util.List;

import com.eweb.giftbackend.model.Gift;

// import java.util.Collections; 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// import com.backend.yogesh.model.Gift;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftResponse {
    private String message;
    private String id;
    private String gift_name;
    private String gift_price;
    private String gift_image;
    private String gift_rating;
    private String gift_category;
    private Gift data;
}
