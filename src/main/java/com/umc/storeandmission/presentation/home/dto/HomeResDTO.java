package com.umc.storeandmission.presentation.home.dto;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;

import java.util.List;

public class HomeResDTO {

    public record GetHome(
            MemberResDTO.GetHome member,
            List<MissionResDTO.GetInfo> missions
    ) {}
}
