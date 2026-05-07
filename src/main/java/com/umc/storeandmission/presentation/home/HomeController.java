package com.umc.storeandmission.presentation.home;

import com.umc.storeandmission.application.home.HomeService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import com.umc.storeandmission.presentation.home.dto.HomeResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/v1/home")
    public ApiResponse<HomeResDTO.GetHome> getHome(
            @RequestParam Long regionId
            /* 헤더로 유저 정보 받아와야 함 */
    ) {
        Long memberId = 1L;  // 유저 Id 임의로 지정
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, homeService.getHome(memberId, regionId));
    }
}
