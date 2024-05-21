package com.domain.expansion.db_cache_service.service;

import com.domain.expansion.db_cache_service.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User save(User user);
    void deleteById(Long id);
    String getUserInfo(String username);
}
