package com.umc.storeandmission.domain.review.converter;

import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.entity.Review;

import java.util.List;

public class ReviewConverter {
    public static ReviewResDTO.GetMyReviews toGetMyReviews(Review review) {
        return ReviewResDTO.GetMyReviews.builder()
                .reviewId(review.getReviewId())
                .storeId(review.getStore().getStoreId())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }

    public static <T> ReviewResDTO.Pagination<T> toPagination(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer size
    ) {
        return ReviewResDTO.Pagination.<T>builder()
                .data(data)
                .hasNext(hasNext)
                .nextCursor(nextCursor)
                .size(size)
                .build();
    }
}
