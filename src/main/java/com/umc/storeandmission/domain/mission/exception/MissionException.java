package com.umc.storeandmission.domain.mission.exception;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import com.umc.storeandmission.global.apiPayload.exception.ProjectException;

public class MissionException extends ProjectException {
    public MissionException(BaseErrorCode errorCode) { super(errorCode); }
}
