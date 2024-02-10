package com.eweb.giftbackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eweb.giftbackend.model.User;

public interface UserRepository extends JpaRepository<User,String>{
    Optional<User> findByEmail(String email);
}