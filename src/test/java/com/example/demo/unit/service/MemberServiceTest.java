package com.example.demo.unit.service;


import com.example.demo.controller.JoinForm;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;


    @BeforeEach
    void init(){

    }

    @DisplayName("회원가입")
    @Test
    void join(){
        // given
        JoinForm form = new JoinForm("name", 24);
        doReturn(new Member("name", 24)).when(memberRepository)
                .save(any(Member.class));

        // when
        Member member = memberService.join(form);

        // then
        Assertions.assertEquals(member.getName(), form.getName());
        Assertions.assertEquals(member.getAge(), form.getAge());
    }
}
