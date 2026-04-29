package com.umc.storeandmission.domain.member.controller;

import com.umc.storeandmission.domain.member.dto.AuthReqDTO;
import com.umc.storeandmission.domain.member.dto.AuthResDTO;
import com.umc.storeandmission.domain.member.exception.code.MemberSuccessCode;
import com.umc.storeandmission.domain.member.service.AuthService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse<AuthResDTO.Signup> signup(
            @RequestBody AuthReqDTO.Signup dto
    ) {
        BaseSuccessCode code = MemberSuccessCode.MEMBER_CREATED;
        return ApiResponse.onSuccess(code, authService.signup(dto));
    }
}
