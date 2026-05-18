package com.umc.storeandmission.domain.member.repository;

import com.umc.storeandmission.domain.member.entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<Term, Long> {
}
