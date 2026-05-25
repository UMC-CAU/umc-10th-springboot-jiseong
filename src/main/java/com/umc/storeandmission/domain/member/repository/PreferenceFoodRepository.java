package com.umc.storeandmission.domain.member.repository;

import com.umc.storeandmission.domain.member.entity.PreferenceFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceFoodRepository extends JpaRepository<PreferenceFood, Long> {
}
