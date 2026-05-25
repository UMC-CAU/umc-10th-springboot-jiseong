package com.umc.storeandmission.domain.member.repository;

import com.umc.storeandmission.domain.member.entity.mapping.MemberPf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPfRepository extends JpaRepository<MemberPf, Integer> {
}
