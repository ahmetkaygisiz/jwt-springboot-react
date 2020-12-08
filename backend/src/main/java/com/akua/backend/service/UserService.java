package com.akua.backend.service;

import com.akua.backend.model.User;
import com.akua.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User create(User user){
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        return user;
    }
}
