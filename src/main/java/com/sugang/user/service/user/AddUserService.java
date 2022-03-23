package com.sugang.user.service.user;

import com.sugang.user.common.enums.AccessLevel;
import com.sugang.user.controller.user.dto.request.AuthUserRequest;
import com.sugang.user.domain.entity.User;
import com.sugang.user.domain.repository.StudentRepository;
import com.sugang.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddUserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public void addUser(AuthUserRequest authUserRequest) {
        User user = userRepository.save(authUserRequest.toEntity());

        System.out.println(user.getUserId());
        System.out.println(user.getName());
        System.out.println(user.getPermissions());

        if (user.getPermissions() == AccessLevel.STUDENT.getAccessLevel())
            studentRepository.save(user.toStudent(authUserRequest.getGrade()));
    }
}
