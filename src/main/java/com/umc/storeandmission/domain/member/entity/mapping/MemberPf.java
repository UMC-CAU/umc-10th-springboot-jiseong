package com.umc.storeandmission.domain.member.entity.mapping;

import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.member.entity.PreferenceFood;
import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPf extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pf_id")
    private PreferenceFood perferenceFood;
}
