package com.umc.storeandmission.domain.mission.dto;

public class MissionReqDTO {
    public record GetMyMissions(
            Long memberId
    ) {}
}
