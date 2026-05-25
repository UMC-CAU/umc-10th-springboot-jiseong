package com.umc.storeandmission.domain.member.service;

import com.umc.storeandmission.domain.member.dto.AuthReqDTO;
import com.umc.storeandmission.domain.member.dto.AuthResDTO;
import com.umc.storeandmission.domain.member.entity.Member;
import com.umc.storeandmission.domain.member.entity.Term;
import com.umc.storeandmission.domain.member.entity.mapping.MemberPf;
import com.umc.storeandmission.domain.member.entity.mapping.MemberTerm;
import com.umc.storeandmission.domain.member.exception.MemberException;
import com.umc.storeandmission.domain.member.exception.code.MemberErrorCode;
import com.umc.storeandmission.domain.member.repository.*;
import com.umc.storeandmission.global.apiPayload.code.GeneralErrorCode;
import com.umc.storeandmission.global.apiPayload.exception.ProjectException;
import com.umc.storeandmission.global.security.entity.AuthMember;
import com.umc.storeandmission.global.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final MemberRepository memberRepository;
    private final TermRepository termRepository;
    private final MemberTermRepository memberTermRepository;
    private final PreferenceFoodRepository preferenceFoodRepository;
    private final MemberPfRepository memberPfRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResDTO.Signup signup(AuthReqDTO.Signup dto) {
        if (memberRepository.existsByEmail(dto.email()))
            throw new MemberException(MemberErrorCode.MEMBER_ALREADY_EXISTS);

        String encryptedPw = passwordEncoder.encode(dto.password());

        // Converter를 써야 하나
        Member member = Member.builder()
                .name(dto.name())
                .password(encryptedPw)
                .gender(dto.gender())
                .birthday(dto.birthday())
                .email(dto.email())
                .address(dto.address())
                .build();

        Long memberId = memberRepository.save(member).getMemberId();

        // 약관 동의 저장
        List<Long> termIdList = dto.terms().stream()
                        .map(AuthReqDTO.TermAgreement::getTermId)
                                .toList();
        Map<Long, Term> termMap = termRepository.findAllById(termIdList).stream()
                        .collect(Collectors.toMap(Term::getTermId, term -> term));
        List<MemberTerm> memberTerms = dto.terms().stream()
                .map(ta -> {
                    Term term = termMap.get(ta.getTermId());
                    if (term == null) throw new ProjectException(GeneralErrorCode.NOT_FOUND);

                    return MemberTerm.builder()
                            .member(member)
                            .term(term)
                            .isAgreed(ta.getIsAgreed())
                            .build();
                }).toList();
        memberTermRepository.saveAll(memberTerms);

        // 선호 음식 저장
        List<MemberPf> memberPfs = preferenceFoodRepository.findAllById(
                dto.preferredFoodIds()
        ).stream()
                .map(pf -> MemberPf.builder()
                            .member(member)
                            .preferenceFood(pf)
                            .build()
                )
                .toList();
        memberPfRepository.saveAll(memberPfs);

        return new AuthResDTO.Signup(memberId);
    }

    public AuthResDTO.Login login(AuthReqDTO.Login dto) {
        Member m = memberRepository.getMemberByEmail(dto.email())
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_UNAUTHORIZED));

        if (!passwordEncoder.matches(dto.password(), m.getPassword()))
            throw new MemberException(MemberErrorCode.MEMBER_UNAUTHORIZED);

        String token = jwtUtil.createAccessToken(new AuthMember(m));

        return new AuthResDTO.Login(token);
    }
}
