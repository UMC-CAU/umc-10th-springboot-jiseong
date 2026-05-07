package com.umc.storeandmission.domain.review.service;

import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.mission.entity.Store;
import com.umc.storeandmission.domain.mission.exception.StoreException;
import com.umc.storeandmission.domain.mission.exception.code.StoreErrorCode;
import com.umc.storeandmission.domain.mission.repository.StoreRepository;
import com.umc.storeandmission.domain.review.dto.ReviewReqDTO;
import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.entity.Review;
import com.umc.storeandmission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
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
}
