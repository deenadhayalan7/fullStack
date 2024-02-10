package com.eweb.giftbackend.Service;

import com.eweb.giftbackend.dto.request.GiftRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.GiftResponse;

public interface GiftService {
    BasicResponse<GiftResponse> getAllGifts();
    GiftResponse createGift(GiftRequest request);
    BasicResponse<GiftResponse> deletegift(String id);
    GiftResponse updateGift(String id,GiftRequest request);
}