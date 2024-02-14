package com.eweb.giftbackend.Service;

import com.eweb.giftbackend.dto.response.BasicResponse;
import com.eweb.giftbackend.dto.response.UserResponse;

public interface UserService {
    BasicResponse<UserResponse>getAllUser();
}
