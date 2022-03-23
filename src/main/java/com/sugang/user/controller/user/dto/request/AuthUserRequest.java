package com.sugang.user.controller.user.dto.request;

import com.sugang.user.domain.entity.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserRequest {

    private String uniqueId;
    private int grade;
    private int room;
    private int number;
    private String name;
    private String profileImage;
    private int accessLevel;
    private String email;

    public User toEntity() {
        return User.builder()
                .userId(getUniqueId())
                .name(getName())
                .permissions(getAccessLevel())
                .build();
    }
}
