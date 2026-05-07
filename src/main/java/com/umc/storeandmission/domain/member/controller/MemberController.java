package com.umc.storeandmission.domain.member.controller;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.service.MemberService;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import com.umc.storeandmission.domain.mission.exception.code.MissionSuccessCode;
import com.umc.storeandmission.domain.mission.service.MissionService;
import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.exception.code.ReviewSuccessCode;
import com.umc.storeandmission.domain.review.service.ReviewService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class MemberController {
    private final MemberService memberService;
    private final MissionService missionService;
    private final ReviewService reviewService;

    @GetMapping("/me/missions")
    public ApiResponse<List<MissionResDTO.GetInfo>> getMyMissions(
            Pageable pageable  // 페이징 객체
            /* 헤더에서 유저 정보 가져와야 함 */
    ) {
        Long memberId = 1L;  // 유저 Id 임의로 설정
        BaseSuccessCode code = MissionSuccessCode.MISSION_OK;
        return ApiResponse.onSuccess(code, missionService.getMissionsByUserId(memberId, pageable));
    }

    @GetMapping("/me/missions/complete-count")
    public ApiResponse<MemberResDTO.GetCompleteCount> getMissionsCompleteCount(
        // 헤더에서 유저 정보 가져와야 함
    ) {
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.getMyCompleteCount(/*유저 정보*/));
    }

    @GetMapping("/me/reviews")
    public ApiResponse<List<ReviewResDTO.GetMyReview>> getMyReviews(
            // 헤더에서 유저 정보 가져와야 함
    ) {
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewService.getReviewsByUserId(/*유저 정보*/));
    }
}
