package com.umc.storeandmission.domain.member.controller;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.service.MemberService;
import com.umc.storeandmission.domain.mission.entity.Mission;
import com.umc.storeandmission.domain.mission.exception.code.MissionSuccessCode;
import com.umc.storeandmission.domain.mission.service.MissionService;
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

    @GetMapping("/me/missions")
    public ApiResponse<List<Mission>> getMissions(
            // 헤더에서 유저 정보 가져와야 함
    ) {
        BaseSuccessCode code = MissionSuccessCode.MISSION_OK;
        return ApiResponse.onSuccess(code, missionService.getMyMissions(/*유저 정보*/));
    }

    @GetMapping("/me/missions/complete-count")
    public ApiResponse<MemberResDTO.GetCompleteCount> getMissionsCompleteCount(
        // 헤더에서 유저 정보 가져와야 함
    ) {
        BaseSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, missionService.getMyCompleteCount(/*유저 정보*/));
    }
}
