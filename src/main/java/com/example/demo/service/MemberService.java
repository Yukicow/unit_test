package com.example.demo.service;


import com.example.demo.controller.JoinForm;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ForeignKey;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(JoinForm form) {
        return memberRepository.save(new Member(form.getName(), form.getAge()));
    }
}
