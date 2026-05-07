package com.umc.storeandmission.domain.review.exception;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import com.umc.storeandmission.global.apiPayload.exception.ProjectException;

public class ReviewException extends ProjectException {
    public ReviewException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
