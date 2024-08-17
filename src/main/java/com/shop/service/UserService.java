package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.User;
import com.shop.repository.UserRepository;

/**
 * Service class for managing {@link User} entities.
 * Provides business logic and interacts with the {@link UserRepository} for CRUD operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a user entity.
     *
     * @param user the user entity to save
     * @return the saved user entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Finds a user entity by its ID.
     *
     * @param id the ID of the user to find
     * @return an {@link Optional} containing the user with the specified ID, or empty if not found
     */
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Finds a user entity by its username.
     *
     * @param username the username of the user to find
     * @return an {@link Optional} containing the user with the specified username, or empty if not found
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Finds users by their role.
     *
     * @param role the role of the users to search for
     * @return a list of users with the specified role
     */
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    /**
     * Finds users whose usernames contain the specified keyword.
     *
     * @param keyword the keyword to search for in usernames
     * @return a list of users with usernames containing the specified keyword
     */
    public List<User> findByUsernameContaining(String keyword) {
        return userRepository.findByUsernameContaining(keyword);
    }

    /**
     * Deletes a user entity by its ID.
     *
     * @param id the ID of the user to delete
     */
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
