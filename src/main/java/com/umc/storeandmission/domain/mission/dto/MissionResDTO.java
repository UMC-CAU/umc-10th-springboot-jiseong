package com.umc.storeandmission.domain.mission.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {
    @Builder
    public record GetInfo(
            @NotNull
            Long storeId,  // 미션 페이지에서 리뷰 남기기 같은거 하려면 id를 알아야 할듯

            @NotBlank(message = "storeName은 필수입니다.")
            String storeName,

            @NotBlank(message = "content는 필수입니다.")
            String content,

            @NotNull(message = "reward는 필수입니다.")
            Integer reward,

            @NotNull(message = "deadline은 필수입니다.")
            LocalDate deadline
    ) {}

    @Builder
    public record GetHome(
            @NotNull(message = "missionId는 필수입니다.")
            Long missionId,

            @NotBlank(message = "storeName은 필수입니다.")
            String storeName,

            @NotBlank(message = "content는 필수입니다.")
            String content,

            @NotNull(message = "reward는 필수입니다.")
            Integer reward,

            @NotNull(message = "deadline은 필수입니다.")
            LocalDate deadline
    ) {}

    @Builder
    public record Pagination<T>(
            List<T> data,
            Integer page,
            Integer size
    ) {}
}
