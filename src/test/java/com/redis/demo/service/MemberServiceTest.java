package com.redis.demo.service;

import com.redis.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void redisSaveTest() throws Exception{
        //given
        Member member = new Member(1L, "user01", 10);
        memberService.addMember(member);
        //when
        Member findMember = memberService.findOne(member.getId());
        System.out.println("findMember.getUsername() = " + findMember.getUsername());
        //then
    }

}