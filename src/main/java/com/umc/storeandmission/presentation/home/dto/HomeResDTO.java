package com.umc.storeandmission.presentation.home.dto;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import jakarta.validation.Valid;

public class HomeResDTO {

    public record GetHome(
            @Valid
            MemberResDTO.GetHome member,

            @Valid
            MissionResDTO.Pagination<MissionResDTO.GetHome> missions
    ) {}
}
