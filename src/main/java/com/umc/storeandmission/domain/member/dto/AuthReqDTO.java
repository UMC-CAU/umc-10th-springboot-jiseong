package com.umc.storeandmission.domain.member.dto;

import com.umc.storeandmission.domain.member.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class AuthReqDTO {

    public record Login(
            @NotBlank(message = "이메일은 필수입니다.")
            @Email(message = "이메일 형식이 잘못되었습니다.")
            String email,

            @NotBlank(message = "비밀번호는 필수입니다.")
            String password
    ) {}

    public record Signup(
        @NotBlank(message = "이름은 필수입니다.")
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password,

        Gender gender,

        LocalDate birthday,

        @NotBlank(message = "주소는 필수입니다.")
        String address,

        @NotNull(message = "약관 동의 여부는 필수입니다.")
        List<TermAgreement> terms,

        List<Long> preferredFoodIds
    ) {}

    @Getter
    public static class TermAgreement {
        private Long termId;
        private Boolean isAgreed;
    }
}
