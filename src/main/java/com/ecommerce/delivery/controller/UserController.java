package com.ecommerce.delivery.controller;

import com.ecommerce.delivery.dto.UserDTO;
import com.ecommerce.delivery.model.User;
import com.ecommerce.delivery.service.UserService;
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
}
