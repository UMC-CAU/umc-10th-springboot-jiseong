package com.umc.storeandmission.domain.review.dto;

import java.util.List;

public class ReviewResDTO {

    public record CreateReview(
            Long reviewId
    ) {}

    public record GetInfo(
            Long reviewId,
            Long StoreId,
            Long userId,
            String content,
            Integer rating,
            List<String> reviewImageUrl
    ) {}

    public record GetMyReview(
            Long reviewId,
            Long StoreId,
            String content,
            Integer rating,
            List<String> reviewImageUrl
    ) {}
}
