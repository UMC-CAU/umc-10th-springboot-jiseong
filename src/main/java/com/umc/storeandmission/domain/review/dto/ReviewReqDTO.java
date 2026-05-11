package com.umc.storeandmission.domain.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewReqDTO {

    public record CreateReview(
            @NotBlank(message = "content는 필수입니다.")
            String content,

            @NotNull(message = "rating은 필수입니다.")
            Integer rating
    ) {}

    public record GetMyReviews(
            Long memberId
    ) {}
}
