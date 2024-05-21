package com.domain.expansion.db_cache_service.service.impl;

import com.domain.expansion.db_cache_service.model.User;
import com.domain.expansion.db_cache_service.repository.UserRepository;
import com.domain.expansion.db_cache_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String getUserInfo(String username) {
        String userInfo = redisTemplate.opsForValue().get(username);

        if (userInfo == null) {
            User user = userRepository.findByUsername(username);
            userInfo = user != null ? user.getUsername() + ", " + user.getPassword() : null;
            if (userInfo != null) {
                redisTemplate.opsForValue().set(username, userInfo);
            }
        }

        return userInfo;
    }
}
