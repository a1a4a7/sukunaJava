package com.domain.expansion.db_cache_service.service;

import com.domain.expansion.db_cache_service.model.User;
import com.domain.expansion.db_cache_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RetryTemplate retryTemplate;

    public List<User> findAll() {
        return retryTemplate.execute(context -> userRepository.findAll());
    }

    public User findByUsername(String username) {
        return retryTemplate.execute(context -> userRepository.findByUsername(username));
    }

    public User save(User user) {
        return retryTemplate.execute(context -> userRepository.save(user));
    }

    public void deleteById(Long id) {
        retryTemplate.execute(context -> {
            userRepository.deleteById(id);
            return null;
        });
    }
}
