package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entities.User;
import com.shop.service.UserService;

/**
 * Controller for handling user-related requests.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create or update a user.
     *
     * @param user The user to be created or updated.
     * @return ResponseEntity with the saved user.
     */
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    /**
     * Get a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return ResponseEntity with the user or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get a user by username.
     *
     * @param username The username of the user to retrieve.
     * @return ResponseEntity with the user or a 404 status if not found.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get users by role.
     *
     * @param role The role of the users to retrieve.
     * @return ResponseEntity with a list of users with the specified role.
     */
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.findByRole(role));
    }

    /**
     * Get users by username containing a keyword.
     *
     * @param keyword The keyword to search for in usernames.
     * @return ResponseEntity with a list of users whose username contains the keyword.
     */
    @GetMapping("/search/username/{keyword}")
    public ResponseEntity<List<User>> getUsersByUsernameContaining(@PathVariable String keyword) {
        return ResponseEntity.ok(userService.findByUsernameContaining(keyword));
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
