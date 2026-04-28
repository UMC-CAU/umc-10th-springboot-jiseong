package com.umc.storeandmission.domain.member.entity;

import com.umc.storeandmission.domain.member.enums.Gender;
import com.umc.storeandmission.domain.member.enums.SocialLoginType;
import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    @NotBlank
    private String address;

    private Long point;

    @NotBlank
    private String email;

    @Column(name = "social_login_type")
    @Enumerated(EnumType.STRING)
    private SocialLoginType socialLoginType;

    @Column(name = "social_login_id")
    private Long socialLoginId;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

}
