package com.umc.storeandmission.domain.member.entity;

import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Getter
public class PreferenceFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pf_id")
    private Long pfId;

    @NotBlank
    private String name;
}
