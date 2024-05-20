package com.domain.expansion.db_cache_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public String getUserInfo(String username) {
        // 从Redis缓存中获取用户信息
        String userInfo = redisTemplate.opsForValue().get(username);

        if (userInfo == null) {
            // 如果缓存未命中，从数据库中查询
            userInfo = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", String.class)
                    .setParameter("username", username)
                    .getSingleResult();
            // 将结果存入Redis缓存
            redisTemplate.opsForValue().set(username, userInfo);
        }

        return userInfo;
    }
}
