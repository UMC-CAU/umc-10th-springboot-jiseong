package com.umc.storeandmission.application.home;

import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.member.service.MemberService;
import com.umc.storeandmission.domain.mission.exception.RegionException;
import com.umc.storeandmission.domain.mission.exception.code.RegionErrorCode;
import com.umc.storeandmission.domain.mission.repository.RegionRepository;
import com.umc.storeandmission.domain.mission.service.MissionService;
import com.umc.storeandmission.presentation.home.dto.HomeResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final MemberService memberService;
    private final MissionService missionService;
    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;

    public HomeResDTO.GetHome getHome(Long memberId, Long regionId, Pageable pageable) {
        if (!memberRepository.existsById(memberId)) throw new MemberException(MemberErrorCode.MEMBER_NOT_FOUND);
        if (!regionRepository.existsById(regionId)) throw new RegionException(RegionErrorCode.REGION_NOT_FOUND);

        return new HomeResDTO.GetHome(
                memberService.getHome(memberId, regionId),
                missionService.getHome(memberId, regionId, pageable)
        );
    }
}
