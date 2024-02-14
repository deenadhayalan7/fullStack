package com.eweb.giftbackend.Controller;

import static com.eweb.giftbackend.utils.MyConstant.USER;
import static com.eweb.giftbackend.utils.MyConstant.USERLIST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eweb.giftbackend.Service.UserService;
import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.UserResponse;

import lombok.RequiredArgsConstructor;

@RequestMapping(USER)
@RestController
@RequiredArgsConstructor
public class UserController {
       private final UserService userService;
       @GetMapping(USERLIST)
       public ResponseEntity<BasicResponse<UserResponse>> create() {
        BasicResponse<UserResponse> response=new BasicResponse<>();


           try {
               response=userService.getAllUser();
               return new ResponseEntity<>(response, OK);
           } catch (Exception e) {
               response.setMessage("Something went wrong!");
               return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
       }
   
   
}