package com.umc.storeandmission.domain.review.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    REVIEW_BAD_REQUEST(HttpStatus.BAD_REQUEST,
            "REVIEW400_1",
            "리뷰 정보가 잘못되었습니다."),
    REVIEW_INVALID_QUERY(HttpStatus.BAD_REQUEST,
            "REVIEW400_2",
            "잘못된 query 값입니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "리뷰를 찾을 수 없습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
