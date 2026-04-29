package com.umc.storeandmission.domain.review.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReplySuccessCode implements BaseSuccessCode {
    REPLY_OK(HttpStatus.OK,
            "REPLY200_1",
            "성공적으로 답글을 조회했습니다."),
    REPLY_CREATED(HttpStatus.CREATED,
            "REPLY201_1",
            "성공적으로 답글을 작성했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
