package com.umc.storeandmission.domain.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

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

    @Builder
    public record GetMyReviews(
            Long reviewId,
            Long storeId,
            String content,
            Integer rating

            // List<String> reviewImageUrl
    ) {}

    @Builder
    public record Pagination<T>(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer size
    ) {}
}
