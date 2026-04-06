package com.umc.storeandmission.domain.member.entity;

import com.umc.storeandmission.domain.member.enums.TermType;
import com.umc.storeandmission.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Term extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
    private Long termId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TermType termType;

    @NotNull
    private Integer version;
}
