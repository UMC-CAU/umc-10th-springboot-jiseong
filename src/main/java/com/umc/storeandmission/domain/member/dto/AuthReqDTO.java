package com.umc.storeandmission.domain.member.dto;

import com.umc.storeandmission.domain.member.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public class AuthReqDTO {

    public record Signup(
        String name,
        Gender gender,
        LocalDate birthday,
        String address,
        List<TermAgreement> terms,
        List<String> preferredFoods
    ) {}

    public static class TermAgreement {
        private Long termId;
        private Boolean isAgreed;
    }
}
