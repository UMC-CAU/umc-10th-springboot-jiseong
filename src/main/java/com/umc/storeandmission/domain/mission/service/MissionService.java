package com.umc.storeandmission.domain.mission.service;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import com.umc.storeandmission.domain.mission.entity.Mission;
import com.umc.storeandmission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    public List<MissionResDTO.GetInfo> getMissionsByUserId(Long memberId, Long regionId, Pageable pageable) {
        if (!memberRepository.existsById(memberId)) throw new MemberException(MemberErrorCode.MEMBER_NOT_FOUND);

        Page<Mission> res = missionRepository.findMissionsByMemberIdAndRegionId(memberId, regionId, pageable);
        List<MissionResDTO.GetInfo> list = res.stream().map(m ->
            MissionResDTO.GetInfo.builder()
                    .storeId(m.getStore().getStoreId())  // Batch Size 설정함
                    .storeName(m.getStore().getName())
                    .content(m.getContent())
                    .reward(m.getReward())
                    .deadline(m.getDeadline())
                    .build()
        ).toList();

        return list;
    }

    public List<MissionResDTO.GetHome> getHome(Long memberId, Long regionId, Pageable pageable) {
        Page<Mission> res = missionRepository.findMissionsByMemberIdAndRegionId(
                memberId, regionId, pageable);

        List<MissionResDTO.GetHome> list = res.map(m ->
            MissionResDTO.GetHome.builder()
                    .missionId(m.getMissionId())
                    .storeName(m.getStore().getName())
                    .reward(m.getReward())
                    .content(m.getContent())
                    .deadline(m.getDeadline())
                    .build()
        ).toList();

        return list;
    }

    // 컴파일 하려고 임의로 만든 메소드, 나중에 제대로 구현해야 함
    public MemberResDTO.GetCompleteCount getMyCompleteCount() {
        return new MemberResDTO.GetCompleteCount(0);
    }
}
