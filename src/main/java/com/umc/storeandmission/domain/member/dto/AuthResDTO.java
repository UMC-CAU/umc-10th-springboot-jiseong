package com.umc.storeandmission.domain.member.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthResDTO {

    public record Signup(
            @NotBlank
            String accessToken
    ) {}
}
