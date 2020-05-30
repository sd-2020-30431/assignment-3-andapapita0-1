package com.anda.assignment2.controller;

import com.anda.assignment2.bean.User;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserQueryController extends UserController {

    public UserQueryController(UserRepository userRepository) {
        super(userRepository);
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
