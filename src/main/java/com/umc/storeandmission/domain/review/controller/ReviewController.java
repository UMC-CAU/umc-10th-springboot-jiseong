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
    ) {
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_CREATED;
        return ApiResponse.onSuccess(code, reviewService.createReview(storeId, dto));
    }
}
