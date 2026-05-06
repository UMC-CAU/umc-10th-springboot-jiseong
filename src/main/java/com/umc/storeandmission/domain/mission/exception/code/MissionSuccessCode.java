package com.umc.storeandmission.domain.mission.exception.code;

import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    MISSION_OK(HttpStatus.OK,
            "MISSION200_1",
            "성공적으로 미션을 조회했습니다."),
    // 데이터 필요하면 204 말고 200으로 변경
    MISSION_SUCCESS(HttpStatus.NO_CONTENT,
            "MISSION204_1",
            "미션이 성공적으로 완료되었습니다."),
    MISSION_ON_PROGRESS(HttpStatus.NO_CONTENT,
            "MISSION_204_2",
            "미션을 진행 상태로 변경하였습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
