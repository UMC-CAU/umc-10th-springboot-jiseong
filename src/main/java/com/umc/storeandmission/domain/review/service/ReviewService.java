package com.umc.storeandmission.domain.review.service;

import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.mission.entity.Store;
import com.umc.storeandmission.domain.mission.exception.StoreException;
import com.umc.storeandmission.domain.mission.exception.code.StoreErrorCode;
import com.umc.storeandmission.domain.mission.repository.StoreRepository;
import com.umc.storeandmission.domain.review.converter.ReviewConverter;
import com.umc.storeandmission.domain.review.dto.ReviewReqDTO;
import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.entity.Review;
import com.umc.storeandmission.domain.review.exception.ReviewException;
import com.umc.storeandmission.domain.review.exception.code.ReviewErrorCode;
import com.umc.storeandmission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ReviewResDTO.CreateReview createReview(Long memberId, Long storeId, ReviewReqDTO.CreateReview dto) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(dto.content())
                .rating(dto.rating())
                .build();
        Long reviewId = reviewRepository.save(review).getReviewId();

        return new ReviewResDTO.CreateReview(reviewId);
    }

    public ReviewResDTO.Pagination<ReviewResDTO.GetMyReviews> getReviewsByMemberId(
            Long memberId,
            Integer size,
            String cursor,
            String query
    ) {
        PageRequest pageRequest = PageRequest.of(0, size);

        long idCursor;
        Slice<Review> reviewList;
        String nextCursor;

        if (!cursor.isBlank()) {
            String[] cursorSplit = cursor.split(":");
            if (cursor.length() != 2) throw new ReviewException(ReviewErrorCode.REVIEW_INVALID_QUERY);

            switch (query.toLowerCase()) {
                case "id":
                    idCursor = Long.parseLong(cursorSplit[1]);

                    reviewList = reviewRepository.getReviewsByMember_MemberIdAndReviewIdLessThanOrderByReviewIdDesc(
                            memberId,
                            idCursor,
                            pageRequest
                    );

                    nextCursor = reviewList.getContent().getLast().getReviewId()
                            + ":" + reviewList.getContent().getLast().getReviewId();
                    break;
                case "rating":
                    Integer ratingCursor = Integer.parseInt(cursorSplit[0]);
                    idCursor = Long.parseLong(cursorSplit[1]);

                    reviewList = reviewRepository.getReviewsByMemberIdOrderByRatingDescSliced(
                            memberId,
                            ratingCursor,
                            idCursor,
                            pageRequest
                    );

                    nextCursor = reviewList.getContent().getLast().getRating()
                            + ":" + reviewList.getContent().getLast().getReviewId();
                    break;
                default:
                    throw new ReviewException(ReviewErrorCode.REVIEW_INVALID_QUERY);
            }
        }
        else {
            switch (query.toLowerCase()) {
                case "id":
                    reviewList = reviewRepository.getReviewsByMember_MemberIdOrderByReviewIdDesc(
                            memberId,
                            pageRequest
                    );
                    nextCursor = reviewList.getContent().getLast().getReviewId()
                            + ":" + reviewList.getContent().getLast().getReviewId();
                    break;
                case "rating":
                    reviewList = reviewRepository.getReviewsByMember_MemberIdOrderByRatingDescReviewIdDesc(
                            memberId,
                            pageRequest
                    );
                    nextCursor = reviewList.getContent().getLast().getRating()
                            + ":" + reviewList.getContent().getLast().getReviewId();
                    break;
                default:
                    throw new ReviewException(ReviewErrorCode.REVIEW_INVALID_QUERY);
            }
        }

        return ReviewConverter.toPagination(
                reviewList.map(ReviewConverter::toGetMyReviews).toList(),
                reviewList.hasNext(),
                nextCursor,
                reviewList.getSize()
        );
    }
}
