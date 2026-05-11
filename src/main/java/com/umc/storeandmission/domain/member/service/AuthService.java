package com.umc.storeandmission.domain.member.service;

import com.umc.storeandmission.domain.member.dto.AuthReqDTO;
import com.umc.storeandmission.domain.member.dto.AuthResDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    // 컴파일 하려고 임의로 만든 메소드, 나중에 제대로 구현해야 함
    public AuthResDTO.Signup signup(AuthReqDTO.Signup dto) {
        return new AuthResDTO.Signup("Access Token");
    }
}
