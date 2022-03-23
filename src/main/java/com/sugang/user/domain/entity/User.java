package com.sugang.user.domain.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    @Column
    private String name;

    @Column
    private int permissions;

    public Student toStudent(int grade) {
        return Student.builder()
                .userId(getUserId())
                .grade(grade)
                .user(this)
                .build();
    }
}
