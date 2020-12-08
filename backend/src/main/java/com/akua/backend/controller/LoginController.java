package com.akua.backend.controller;

import com.akua.backend.api.GenericResponse;
import com.akua.backend.model.User;
import com.akua.backend.service.LoginService;
import com.akua.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/1.0/login")
    public GenericResponse login(@RequestBody User user) throws Exception {
        return loginService.login(user);
    }

    @PostMapping("/api/1.0/signup")
    public GenericResponse signUp(@RequestBody User user){
        userService.create(user);

        return new GenericResponse("User created.");
    }
}
