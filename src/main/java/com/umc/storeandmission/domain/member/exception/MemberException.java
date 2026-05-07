package com.umc.storeandmission.domain.member.exception;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import com.umc.storeandmission.global.apiPayload.exception.ProjectException;

public class MemberException extends ProjectException {
    public MemberException(BaseErrorCode errorCode) { super(errorCode); }
}
