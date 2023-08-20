package com.example.demo.unit.respository;


import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    void save(){
        //given
        Member member = new Member("name", 24);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember.getName()).isEqualTo(member.getName());
        assertThat(savedMember.getAge()).isEqualTo(member.getAge());
    }
}
