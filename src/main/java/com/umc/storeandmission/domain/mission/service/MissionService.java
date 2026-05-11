package com.umc.storeandmission.domain.mission.service;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.MemberRepository;
import com.umc.storeandmission.domain.mission.converter.MissionConverter;
import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import com.umc.storeandmission.domain.mission.entity.Mission;
import com.umc.storeandmission.domain.mission.enums.MissionStatus;
import com.umc.storeandmission.domain.mission.exception.RegionException;
import com.umc.storeandmission.domain.mission.exception.code.RegionErrorCode;
import com.umc.storeandmission.domain.mission.repository.MissionRepository;
import com.umc.storeandmission.domain.mission.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;

    public MissionResDTO.Pagination<MissionResDTO.GetInfo> getMissionsByUserId(
            Long memberId,
            Long regionId,
            String status,
            Integer page,
            Integer size,
            String sort
    ) {
        if (!memberRepository.existsById(memberId)) throw new MemberException(MemberErrorCode.MEMBER_NOT_FOUND);
        if (!regionRepository.existsById(regionId)) throw new RegionException(RegionErrorCode.REGION_NOT_FOUND);
        MissionStatus missionStatus = MissionStatus.valueOf(status);

        Sort sortInfo;
        if (sort != null) sortInfo = Sort.by(sort);
        else sortInfo = Sort.by("missionId");
        PageRequest pageRequest = PageRequest.of(page, size, sortInfo);

        Page<Mission> res = missionRepository.findMissionsPaged(memberId, regionId, missionStatus, pageRequest);

        return MissionConverter.toPagination(
                res.map(MissionConverter::toGetInfo).toList(),
                res.getNumber(),
                res.getSize()
        );
    }

    public List<MissionResDTO.GetHome> getHome(Long memberId, Long regionId, Pageable pageable) {
        Page<Mission> res = missionRepository.findMissionsPaged(
                memberId, regionId, pageable);  // 여기 수정해야 함!!!!!

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
