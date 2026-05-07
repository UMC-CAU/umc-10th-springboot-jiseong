package com.umc.storeandmission.domain.mission.repository;

import com.umc.storeandmission.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select m from Mission m " +
            "join MemberMission mbm on m = mbm.mission " +
            "where mbm.member.memberId = :memberId")
    Page<Mission> findMissionsByMemberId(@Param("memberId") Long memberId, Pageable pageable);
}
