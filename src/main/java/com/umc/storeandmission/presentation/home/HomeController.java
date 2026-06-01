package com.umc.storeandmission.presentation.home;

import com.umc.storeandmission.application.home.HomeService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import com.umc.storeandmission.presentation.home.dto.HomeResDTO;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home")
    public ApiResponse<HomeResDTO.GetHome> getHome(
            @RequestParam Long regionId,
            @RequestParam @Min(value = 0, message = "페이지 번호는 0 이상입니다.") Integer page,  // 나중에 페이지 1부터 시작하도록 바꿔야 할듯
            @RequestParam @Range(min = 1, max = 50, message = "페이지 크기는 1 ~ 50입니다.") Integer size,
            @RequestParam String sort
            /* 헤더로 유저 정보 받아와야 함 */
    ) {
        Long memberId = 1L;  // 유저 Id 임의로 지정
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, homeService.getHome(memberId, regionId, page, size, sort));
    }
}
