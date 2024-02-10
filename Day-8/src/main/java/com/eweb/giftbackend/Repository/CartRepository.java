package com.eweb.giftbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eweb.giftbackend.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,String>{

}
