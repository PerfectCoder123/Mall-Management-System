package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.entities.User;

/**
 * Repository interface for managing {@link User} entities.
 * Provides CRUD operations and custom query methods for accessing user data.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return an {@link Optional} containing the user with the specified username, or empty if not found
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds users with the specified role.
     *
     * @param role the role to search for
     * @return a list of users with the specified role
     */
    List<User> findByRole(String role);

    /**
     * Finds users whose username contains the specified keyword.
     *
     * @param keyword the substring to search for in usernames
     * @return a list of users with usernames containing the specified keyword
     */
    List<User> findByUsernameContaining(String keyword);

    /**
     * Finds users whose username starts with the specified prefix.
     *
     * @param prefix the prefix to search for in usernames
     * @return a list of users with usernames starting with the specified prefix
     */
    List<User> findByUsernameStartingWith(String prefix);

    /**
     * Finds users whose username ends with the specified suffix.
     *
     * @param suffix the suffix to search for in usernames
     * @return a list of users with usernames ending with the specified suffix
     */
    List<User> findByUsernameEndingWith(String suffix);

    /**
     * Finds users with a username that matches the specified username, ignoring case.
     *
     * @param username the username to search for, case insensitive
     * @return a list of users with usernames matching the specified username, ignoring case
     */
    List<User> findByUsernameIgnoreCase(String username);
}
