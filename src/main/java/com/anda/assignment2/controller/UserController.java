package com.anda.assignment2.controller;


import com.anda.assignment2.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public abstract class UserController {

    protected final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
