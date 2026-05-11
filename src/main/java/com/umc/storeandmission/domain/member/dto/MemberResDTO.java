package com.umc.storeandmission.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
            @NotBlank(message = "name은 필수입니다.")
            String name,

            @NotBlank(message = "email은 필수입니다.")
            String email,

            @NotBlank(message = "phoneNumber는 필수입니다.")
            String phoneNumber,

            @NotNull(message = "point는 필수입니다.")
            Long point
    ) { }
}
