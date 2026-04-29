package com.umc.storeandmission.domain.review.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReplyErrorCode implements BaseErrorCode {
    REPLY_BAD_REQUEST(HttpStatus.BAD_REQUEST,
            "REPLY400_1",
            "답글 정보가 잘못되었습니다."),
    REPLY_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REPLY404_1",
            "답글을 찾을 수 없습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
