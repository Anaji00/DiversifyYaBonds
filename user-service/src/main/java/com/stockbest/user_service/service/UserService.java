package com.stockbest.user_service.service; // package for business logic

import com.stockbest.user_service.model.User;            // import User entity
import com.stockbest.user_service.repository.UserRepository; // import repository
import org.springframework.stereotype.Service;          // marks as Spring service

import java.util.List; // for returning lists
import java.util.Optional; // for optional returns

// @Service marks this as a Spring-managed business service
@Service
public class UserService {

    private final UserRepository userRepository; // our JPA repository

    // constructor injection of UserRepository (recommended style)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; // store the reference
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll(); // JPA does this automatically
    }

    // get a user by id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id); // safe, returns Optional
    }

    // add a new user
    public User createUser(User user) {
        return userRepository.save(user); // save user to database
    }

    // update user
    public User updateUser(Long id, User updatedUser) {
        // find if user exists
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) { // user exists
            User existingUser = userOpt.get(); // get user
            existingUser.setUsername(updatedUser.getUsername()); // update fields
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser); // save updated
        } else {
            return null; // user not found
        }
    }

    // delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // delete by id
    }
}
