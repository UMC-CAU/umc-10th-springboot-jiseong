package com.umc.storeandmission.domain.member.dto;

public class AuthResDTO {

    public record Signup(
            String accessToken
    ) {}
}
