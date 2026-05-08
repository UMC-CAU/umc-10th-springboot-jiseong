package com.umc.storeandmission.domain.mission.exception;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import com.umc.storeandmission.global.apiPayload.exception.ProjectException;

public class RegionException extends ProjectException {
    public RegionException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
