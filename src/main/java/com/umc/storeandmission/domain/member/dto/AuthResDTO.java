package com.umc.storeandmission.domain.member.dto;

public class AuthResDTO {
    public record Signup(
            Long memberId
    ) {}

    public record Login(
            String accessToken
            // String refreshToken
    ) {};
}
