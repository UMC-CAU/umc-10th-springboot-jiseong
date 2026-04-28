package com.umc.storeandmission.domain.member.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {
    MEMBER_OK(HttpStatus.OK,
            "MEMBER200_1",
            "성공적으로 유저를 조회했습니다."),
    MEMBER_CREATED(HttpStatus.CREATED,
            "MEMBER201_1",
            "성공적으로 유저를 생성했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
