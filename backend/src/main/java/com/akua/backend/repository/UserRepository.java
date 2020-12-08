package com.akua.backend.repository;

import com.akua.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    User findByUsername(String username);
}
