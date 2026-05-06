package com.umc.storeandmission.presentation.home;

import com.umc.storeandmission.application.home.HomeService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import com.umc.storeandmission.presentation.home.dto.HomeReqDTO;
import com.umc.storeandmission.presentation.home.dto.HomeResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/v1/home")
    public ApiResponse<HomeResDTO.GetHome> getHome(
            /* 헤더로 유저 정보 받아와야 함 */
    ) {
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, homeService.getHome(dto));
    }
}
