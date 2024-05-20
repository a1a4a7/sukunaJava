package com.domain.expansion.db_cache_service.repository;

import com.domain.expansion.db_cache_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
