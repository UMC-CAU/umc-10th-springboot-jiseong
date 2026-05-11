package com.umc.storeandmission.domain.review.repository;

import com.umc.storeandmission.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
