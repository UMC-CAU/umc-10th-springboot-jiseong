package com.umc.storeandmission.domain.review.repository;

import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Slice<Review> getReviewsByMember_MemberIdOrderByReviewIdDesc(
            Long memberId,
            Pageable pageable
    );

    Slice<Review> getReviewsByMember_MemberIdOrderByRatingDescReviewIdDesc(
            Long memberId,
            Pageable pageable
    );

    Slice<Review> getReviewsByMember_MemberIdAndReviewIdLessThanOrderByReviewIdDesc(
            Long memberId,
            Long reviewId,
            Pageable pageable
    );

    @Query("select r from Review r " +
            "where r.member.memberId = :memberId " +
            "and (r.rating < :ratingCursor " +
            "or (r.rating = :ratingCursor and r.reviewId < :idCursor)) " +
            "order by r.rating desc, r.reviewId desc")
    Slice<Review> getReviewsByMemberIdOrderByRatingDescSliced(
        @Param("memberId") Long memberId,
        @Param("ratingCursor") Double ratingCursor,
        @Param("idCursor") Long idCursor,
        Pageable pageable
    );
}
