package com.umc.storeandmission.domain.member.service;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public MemberResDTO.GetHome getHome(Long memberId, Long regionId) {
        // Member, Region 존재 여부 체크는 HomeService에서 이미 완료

        Member m = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        Long count = missionRepository.countCompletedMissions(memberId, regionId);

        return new MemberResDTO.GetHome(m.getPoint(), count);
    }

    public MemberResDTO.GetMyPage getMyPage(Long memberId) {
        Member m = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
        return MemberResDTO.GetMyPage.builder()
                .name(m.getName())
                .email(m.getEmail())
                .phoneNumber(m.getPhoneNumber())
                .point(m.getPoint())
                .build();
    }
}
