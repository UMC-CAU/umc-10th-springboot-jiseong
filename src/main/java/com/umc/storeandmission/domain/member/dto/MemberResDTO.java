package com.umc.storeandmission.domain.member.dto;

import lombok.Builder;

public class MemberResDTO {
    @Builder
    public record GetInfo(
            String name,
            String phoneNumber,
            String email,
            Long point
    ) {}

    public record GetHome(
            Long point,
            Long numOfMissionSuccess
    ) {}

    public record GetCompleteCount(
            Integer count
    ) {}

    @Builder
    public record GetMyPage(
            String name,
            String email,
            String phoneNumber,
            Long point
    ) { }
}
