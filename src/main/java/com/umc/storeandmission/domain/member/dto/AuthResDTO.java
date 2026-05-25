package com.umc.storeandmission.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthResDTO {

    public record Signup(
            Long memberId
    ) {}
}
