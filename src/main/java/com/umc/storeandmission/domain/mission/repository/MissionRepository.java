package com.umc.storeandmission.domain.mission.repository;

import com.umc.storeandmission.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select count(m) from Mission m " +  // count 함수 사용할 때는 N+1 발생 X
            "join MemberMission mbm on m = mbm.mission " +
            "where mbm.member.memberId = :memberId " +
            "and m.store.region.regionId = :regionId " +
            "and m.missionStatus = 'COMPLETE' ")
    Long countCompletedMissions(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId);

    @Query("select m from Mission m " +
            "join MemberMission mbm on m = mbm.mission " +
            "where mbm.member.memberId = :memberId " +
            "and m.store.region.regionId = :regionId ")
    Page<Mission> findMissionsByMemberIdAndRegionId(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId,
            Pageable pageable);
}
