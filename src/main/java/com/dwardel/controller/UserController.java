package com.dwardel.controller;

import com.dwardel.dto.UserDTO;
import com.dwardel.model.User;
import com.dwardel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Create a new user
    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Create a new user
    @GetMapping("/{id}/address")
    public List<UserDTO> getUserWithAddress(@PathVariable Long id) {
        return userService.getUserWithAddress(id);
    }
}
