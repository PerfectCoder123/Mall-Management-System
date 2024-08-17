package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.MallAdmin;
import com.shop.repository.MallAdminRepository;

/**
 * Service class for managing {@link MallAdmin} entities.
 * Provides business logic and interacts with the {@link MallAdminRepository} for CRUD operations.
 */
@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository mallAdminRepository;

    /**
     * Saves a mall admin entity.
     *
     * @param mallAdmin the mall admin entity to save
     * @return the saved mall admin entity
     */
    public MallAdmin saveMallAdmin(MallAdmin mallAdmin) {
        return mallAdminRepository.save(mallAdmin);
    }

    /**
     * Finds a mall admin by their ID.
     *
     * @param id the ID of the mall admin to find
     * @return an {@link Optional} containing the mall admin with the specified ID, or empty if not found
     */
    public Optional<MallAdmin> findMallAdminById(Long id) {
        return mallAdminRepository.findById(id);
    }

    /**
     * Finds mall admins with the specified role.
     *
     * @param role the role to search for
     * @return an {@link Optional} containing a list of mall admins with the specified role,
     *         or empty if no such admins are found
     */
    public Optional<List<MallAdmin>> findByRole(String role) {
        List<MallAdmin> admins = mallAdminRepository.findByRole(role);
        return admins.isEmpty() ? Optional.empty() : Optional.of(admins);
    }
    
    /**
     * Finds all mall admins.
     *
     * @return an {@link Optional} containing a list of all mall admins,
     *         or empty if no mall admins are found
     */
    public Optional<List<MallAdmin>> findAllEmployees(){
        List<MallAdmin> admins = mallAdminRepository.findAll();
        return admins.isEmpty() ? Optional.empty() : Optional.of(admins);
    }

    /**
     * Finds mall admins whose username contains the specified substring.
     *
     * @param keyword the substring to search for in usernames
     * @return an {@link Optional} containing a list of mall admins with usernames containing the specified substring,
     *         or empty if no such admins are found
     */
    public Optional<List<MallAdmin>> findByUsernameContaining(String keyword) {
        List<MallAdmin> admins = mallAdminRepository.findByUsernameContaining(keyword);
        return admins.isEmpty() ? Optional.empty() : Optional.of(admins);
    }

    /**
     * Deletes a mall admin by their ID.
     *
     * @param id the ID of the mall admin to delete
     * @throws IllegalArgumentException if the mall admin with the given ID does not exist
     */
    public void deleteMallAdminById(Long id) {
        if (mallAdminRepository.existsById(id)) {
            mallAdminRepository.deleteById(id);
        } else {
            // Handles the case where the MallAdmin with the given ID does not exist
            // For example, throw an exception or log a warning
            throw new IllegalArgumentException("MallAdmin with ID " + id + " does not exist.");
        }
    }
}
