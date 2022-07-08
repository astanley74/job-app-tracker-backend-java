package com.icloud.austins10.jobapptracker.controller;

import com.icloud.austins10.jobapptracker.dao.UserRepository;
import com.icloud.austins10.jobapptracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/users")
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value="/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getUserById(id);
    }

    @PostMapping(value="/users")
    public String createUser(@RequestBody User user) {
        LocalDate createdAt = LocalDate.now();
        user.setCreatedAt(createdAt);
        userRepository.save(user);
        return user.getFirstName();
    }

    @PutMapping(value="/users/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User userRequest) {
        return userRepository.findById(id).map(user -> {
            user.setEmailAddress(userRequest.getEmailAddress());
            user.setPassword(userRequest.getPassword());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setUpdatedAt(LocalDate.now());
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("UserId: " + id + " not found."));
    }

    @DeleteMapping(value="/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("UserId: " + id + " not found."));
    }
}
