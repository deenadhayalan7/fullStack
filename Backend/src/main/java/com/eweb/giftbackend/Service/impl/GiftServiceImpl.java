package com.eweb.giftbackend.Service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.eweb.giftbackend.Repository.GiftRepository;
import com.eweb.giftbackend.Service.GiftService;
import com.eweb.giftbackend.dto.request.GiftRequest;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.GiftResponse;
import com.eweb.giftbackend.model.Gift;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {
    private final GiftRepository giftRepo;

    @Override
    public BasicResponse<GiftResponse> getAllGifts() 
    {
        List<Gift> gifts = giftRepo.findAll();
        List<GiftResponse> giftResponses = gifts.stream()
            .map(gift -> GiftResponse.builder()
                .id(gift.getId())
                .gift_name(gift.getGift_name())
                .gift_price(gift.getGift_price())
                .gift_image(gift.getGift_image())
                .gift_rating(gift.getGift_rating())
                .gift_category(gift.getGift_category())
                .build())
            .collect(Collectors.toList());
        return BasicResponse.<GiftResponse>builder()
            .message("success!")
            .data(giftResponses)
            .build();
    }

    private final GiftRepository giftRepository;
    @Override
    public GiftResponse createGift(GiftRequest request) {
        var gift = Gift.builder()
            .gift_name(request.getGift_name())
            .gift_price(request.getGift_price())
            .gift_image(request.getGift_image())
            .gift_rating(request.getGift_rating())
            .gift_category(request.getGift_category())
            .build();
        giftRepository.save(gift);
        return GiftResponse.builder()
            .message("Gift created successfully")
            .build();
    }

    @Override
        public BasicResponse<GiftResponse> deletegift(String giftId) {
            if (giftRepository.existsById(giftId)) {
                giftRepository.deleteById(giftId);
                return BasicResponse.<GiftResponse>builder()
                    .message("Gift deleted successfully")
                    .build();
            } else {
                return BasicResponse.<GiftResponse>builder()
                    .message("Gift not found with ID: " + giftId)
                    .build();
            }
        }

        @Override
        public GiftResponse updateGift(String giftId, GiftRequest request) {
            if (giftRepository.existsById(giftId)) {
                Gift existingGift = giftRepository.findById(giftId).orElse(null);
                if (existingGift != null) {
                    existingGift.setGift_name(request.getGift_name());
                    existingGift.setGift_price(request.getGift_price());
                    existingGift.setGift_image(request.getGift_image());
                    existingGift.setGift_rating(request.getGift_rating());
                    existingGift.setGift_category(request.getGift_category());
                    giftRepository.save(existingGift);
                    return GiftResponse.builder()
                        .message("Gift updated successfully")
                        .build();
                } else {
                    return GiftResponse.builder()
                        .message("Failed to update gift. Gift not found with ID: " + giftId)
                        .build();
                }
            } else {
                return GiftResponse.builder()
                    .message("Failed to update gift. Gift not found with ID: " + giftId)
                    .build();
            }
        }
        

}