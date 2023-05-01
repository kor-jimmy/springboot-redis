package com.redis.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // RedisConnectionFactory를 이용하여 RedisTemplate의 연결 설정
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        /**
         * 각 데이터 타입의 Serializer를 설정
         * */
        // key 타입의 Serializer 설정
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value 타입의 Serializer 설정
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 해시 key 타입의 Serializer 설정
        // redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 해시 value 타입의 Serializer 설정
        // redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        // 기본 Serializer 설정
        // redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        return redisTemplate;

    }
}
