package com.eweb.giftbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eweb.giftbackend.model.Gift;

@Repository

public interface GiftRepository extends JpaRepository<Gift, String> {
   
}
