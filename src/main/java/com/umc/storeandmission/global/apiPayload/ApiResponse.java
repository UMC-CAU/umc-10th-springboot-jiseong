package com.umc.storeandmission.global.apiPayload;

import com.umc.storeandmission.global.apiPayload.code.BaseErrorCode;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private final Boolean success;

    private final String code;

    private final String message;

    private T result;

    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code, T result) {
        return new ApiResponse<T>(true, code.getCode(), code.getMessage(), result);
    }

    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, T result) {
        return new ApiResponse<T>(false, code.getCode(), code.getMessage(), result);
    }
}
