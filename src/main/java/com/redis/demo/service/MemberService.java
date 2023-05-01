package com.redis.demo.service;

import com.redis.demo.entity.Member;
import com.redis.demo.repository.MemberRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRedisRepository memberRedisRepository;

    public void addMember(Member member) {
        memberRedisRepository.save(member);
    }

    public Member findOne(Long id){
        return memberRedisRepository.findById(id).orElse(null);
    }
}
