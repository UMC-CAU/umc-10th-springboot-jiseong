package com.umc.storeandmission.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MissionResDTO {
    @Builder
    public record GetInfo(
        String storeName,
        String content,
        Integer reward,
        LocalDateTime deadline
    ) {}

    @Builder
    public record GetHome(

    ) {}
}
