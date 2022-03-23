package com.sugang.user.common.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserSink {

    String INPUT = "input";

    @Input(UserSink.INPUT)
    SubscribableChannel input();
}
