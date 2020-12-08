package com.akua.backend.controller;

import com.akua.backend.api.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/1.0/home")
    public GenericResponse home(){
        return new GenericResponse("W3lc0m3 h0m3!");
    }
}
