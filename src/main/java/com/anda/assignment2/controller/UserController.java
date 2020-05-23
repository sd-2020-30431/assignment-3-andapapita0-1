package com.anda.assignment2.controller;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.bean.User;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for " +
                        "this id :: " + id));
        return ResponseEntity.ok().body(user);
    }
}
