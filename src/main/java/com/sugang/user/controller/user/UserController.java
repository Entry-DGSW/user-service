package com.sugang.user.controller.user;

import com.sugang.user.common.kafka.UserSink;
import com.sugang.user.controller.user.dto.request.AuthUserRequest;
import com.sugang.user.service.user.AddUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final AddUserService addUserService;

    @StreamListener(UserSink.INPUT)
    public void putUser(AuthUserRequest authUserRequest) {
        addUserService.addUser(authUserRequest);
    }
}
