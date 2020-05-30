package com.anda.assignment2.controller;

import com.anda.assignment2.bean.User;
import com.anda.assignment2.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserCommandController extends UserController{

    public UserCommandController(UserRepository userRepository) {
        super(userRepository);
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
