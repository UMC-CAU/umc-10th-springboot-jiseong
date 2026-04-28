package com.umc.storeandmission.domain.review.dto;

public class ReviewReqDTO {

    public record CreateReview(
            String content,
            Integer rating
    ) {}
}
