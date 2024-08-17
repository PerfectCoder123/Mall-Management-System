package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.entities.MallAdmin;

/**
 * Repository interface for managing {@link MallAdmin} entities.
 * Provides CRUD operations and custom query methods for accessing mall admin data.
 */
public interface MallAdminRepository extends JpaRepository<MallAdmin, Long> {

    /**
     * Finds mall admins with the specified role.
     *
     * @param role the role to search for
     * @return a list of mall admins with the specified role
     */
    List<MallAdmin> findByRole(String role);

    /**
     * Finds mall admins whose username contains the specified keyword.
     *
     * @param keyword the substring to search for in usernames
     * @return a list of mall admins with usernames containing the specified keyword
     */
    List<MallAdmin> findByUsernameContaining(String keyword);

    /**
     * Finds mall admins whose username starts with the specified prefix.
     *
     * @param prefix the prefix to search for in usernames
     * @return a list of mall admins with usernames starting with the specified prefix
     */
    List<MallAdmin> findByUsernameStartingWith(String prefix);

    /**
     * Finds mall admins whose username ends with the specified suffix.
     *
     * @param suffix the suffix to search for in usernames
     * @return a list of mall admins with usernames ending with the specified suffix
     */
    List<MallAdmin> findByUsernameEndingWith(String suffix);

    /**
     * Finds mall admins with a username that matches the specified username, ignoring case.
     *
     * @param username the username to search for, case insensitive
     * @return a list of mall admins with usernames that match the specified username, ignoring case
     */
    List<MallAdmin> findByUsernameIgnoreCase(String username);
}
