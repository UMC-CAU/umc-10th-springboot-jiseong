package com.umc.storeandmission.domain.member.converter;

import com.umc.storeandmission.domain.member.dto.MemberResDTO;
import com.umc.storeandmission.domain.member.entity.Member;

public class MemberConverter {
    public static MemberResDTO.GetMyPage toGetMyPage(Member m) {
        return MemberResDTO.GetMyPage.builder()
                .name(m.getName())
                .email(m.getEmail())
                .phoneNumber(m.getPhoneNumber())
                .point(m.getPoint())
                .build();
    }
}
