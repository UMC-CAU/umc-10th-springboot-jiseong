package com.umc.storeandmission.domain.mission.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RegionErrorCode implements BaseErrorCode {
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REGION_404_1",
            "지역을 찾을 수 없습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
