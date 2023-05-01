package com.redis.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@Setter
@RedisHash(value = "member")
public class Member {

    @Id
    private Long id;
    @Indexed
    private String username;
    private int age;

    public Member(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
