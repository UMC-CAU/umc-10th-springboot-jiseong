package com.umc.storeandmission.domain.mission.repository;

import com.umc.storeandmission.domain.mission.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
