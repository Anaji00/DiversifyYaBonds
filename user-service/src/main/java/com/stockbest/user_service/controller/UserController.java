// UserController handles all REST API requests related to User operations
package com.stockbest.user_service.controller;

import com.stockbest.user_service.model.User;
import com.stockbest.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/users") // Base URL for all user endpoints
public class UserController {

    private final UserService userService; // Service for business logic

    // Constructor injection of UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/users - Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /api/users/{id} - Retrieve a user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // POST /api/users - Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT /api/users/{id} - Update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // DELETE /api/users/{id} - Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}