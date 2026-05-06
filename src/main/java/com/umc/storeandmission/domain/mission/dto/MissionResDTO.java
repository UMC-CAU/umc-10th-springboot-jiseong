package com.umc.storeandmission.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResDTO {
    @Builder
    public record GetInfo(
        Long storeId,  // 미션 페이지에서 리뷰 남기기 같은거 하려면 id를 알아야 할듯
        String storeName,
        String content,
        Integer reward,
        LocalDateTime deadline
    ) {}

    @Builder
    public record GetHome(
    ) {}
}
