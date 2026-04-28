package com.umc.storeandmission.domain.mission.entity.mapping;

import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.mission.entity.Mission;
import com.umc.storeandmission.domain.mission.enums.MissionStatus;
import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;
}
