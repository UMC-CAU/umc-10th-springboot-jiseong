package com.umc.storeandmission.domain.mission.entity;

import com.umc.storeandmission.domain.mission.enums.MissionStatus;
import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long missionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @NotBlank
    private String content;

    @NotNull
    private Integer reward;

    @NotNull
    private LocalDate deadline;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

}
