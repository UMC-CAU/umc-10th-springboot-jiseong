package com.umc.storeandmission.domain.member.controller;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.exception.code.MemberSuccessCode;
import com.umc.storeandmission.domain.member.service.MemberService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import com.umc.storeandmission.global.security.entity.AuthMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyPageController {

    private final MemberService memberService;

    @GetMapping("/v1/mypage")
    public ApiResponse<MemberResDTO.GetMyPage> getMyPage(
            /* 유저 정보 가져와야 함 */
    ) {
        Long memberId = 1L;  // 임의로 유저 Id 지정함
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, memberService.getMyPage(memberId));
    }

    @GetMapping("/v2/mypage")
    public ApiResponse<MemberResDTO.GetMyPage> getMyPage(
            @AuthenticationPrincipal AuthMember member
    ) {
        BaseSuccessCode code = MemberSuccessCode.MEMBER_OK;
        return ApiResponse.onSuccess(code, memberService.getMyPage(member));
    }

}
