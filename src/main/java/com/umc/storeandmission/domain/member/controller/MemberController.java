package com.umc.storeandmission.domain.member.controller;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.service.MemberService;
import com.umc.storeandmission.domain.mission.dto.MissionReqDTO;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import com.umc.storeandmission.domain.mission.exception.code.MissionSuccessCode;
import com.umc.storeandmission.domain.mission.service.MissionService;
import com.umc.storeandmission.domain.review.dto.ReviewReqDTO;
import com.umc.storeandmission.domain.review.dto.ReviewResDTO;
import com.umc.storeandmission.domain.review.exception.code.ReviewSuccessCode;
import com.umc.storeandmission.domain.review.service.ReviewService;
import com.umc.storeandmission.global.apiPayload.ApiResponse;
import com.umc.storeandmission.global.apiPayload.code.BaseSuccessCode;
import com.umc.storeandmission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
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
    public ApiResponse<MissionResDTO.Pagination<MissionResDTO.GetInfo>> getMyMissions(
            @RequestParam Long regionId,
            @RequestParam String status,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(required = false) String sort,
            @RequestParam Long memberId  // 나중에 수정할 예정
    ) {
        BaseSuccessCode code = MissionSuccessCode.MISSION_OK;
        return ApiResponse.onSuccess(code,
                missionService.getMissionsByUserId(
                        memberId,
                        regionId,
                        status,
                        page,
                        size,
                        sort
                ));
    }

    @GetMapping("/me/missions/complete-count")
    public ApiResponse<MemberResDTO.GetCompleteCount> getMissionsCompleteCount(
        // 헤더에서 유저 정보 가져와야 함
    ) {
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.getMyCompleteCount(/*유저 정보*/));
    }

    @GetMapping("/me/reviews")
    public ApiResponse<ReviewResDTO.Pagination<ReviewResDTO.GetMyReviews>> getMyReviews(
            @RequestParam Integer size,
            @RequestParam(defaultValue = "") String cursor,
            @RequestParam String query,
            @RequestParam Long memberId  // 나중에 수정할 예정
    ) {
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_OK;
        return ApiResponse.onSuccess(code,
                reviewService.getReviewsByMemberId(
                        memberId,
                        size,
                        cursor,
                        query
                ));
    }
}
