package com.akua.backend.service;

import com.akua.backend.api.GenericResponse;
import com.akua.backend.model.User;
import com.akua.backend.repository.UserRepository;
import com.akua.backend.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class LoginService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    public GenericResponse<String> login(User user) throws Exception {
        try {
            authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()));

        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new GenericResponse<>("Login successful.", jwt);
    }

    public GenericResponse signUp(User user) {
        userService.create(user);
        return new GenericResponse("");
    }
}
