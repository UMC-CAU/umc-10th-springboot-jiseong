package com.umc.storeandmission.domain.mission.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {
    @Builder
    public record GetInfo(
            Long storeId,
            String storeName,
            String content,
            Integer reward,
            LocalDate deadline
    ) {}

    @Builder
    public record GetHome(
            Long missionId,
            String storeName,
            String content,
            Integer reward,
            LocalDate deadline
    ) {}

    @Builder
    public record Pagination<T>(
            List<T> data,
            Integer page,
            Integer size
    ) {}
}
