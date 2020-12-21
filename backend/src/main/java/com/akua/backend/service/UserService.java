package com.akua.backend.service;

import com.akua.backend.model.User;
import com.akua.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User create(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        log.info("User created!");

        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if (user != null) {
            log.info("User found!");
        } else {
            log.info("user null");
        }

        return user;
    }
}
