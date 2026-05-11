package com.umc.storeandmission.domain.review.controller;

import com.umc.storeandmission.domain.review.dto.ReviewReqDTO;
import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.exception.code.ReviewSuccessCode;
import com.umc.storeandmission.domain.review.service.ReviewService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.CreateReview> createReview(
            @PathVariable Long storeId,
            @RequestBody ReviewReqDTO.CreateReview dto
            /* 유저 데이터 받도록 설정 */
    ) {
        Long memberId = 1L;  // id 임의로 지정
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_CREATED;
        return ApiResponse.onSuccess(code, reviewService.createReview(memberId, storeId, dto));
    }
}
