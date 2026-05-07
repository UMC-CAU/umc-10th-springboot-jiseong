package com.umc.storeandmission.domain.mission.repository;

import com.umc.storeandmission.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
