package com.grocery.app.controller;

import com.grocery.app.model.User;
import com.grocery.app.service.UserService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Saves a user to the database.
     *
     * @param user the user to be saved
     * @return a string indicating that the user was saved
     */
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        var existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userService.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    /**
     * Gets all users from the database.
     *
     * @return a list of all users in the database
     */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }




}
