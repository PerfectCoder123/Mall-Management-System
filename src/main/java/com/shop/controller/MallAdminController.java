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

import com.shop.entities.MallAdmin;
import com.shop.service.MallAdminService;

/**
 * Controller for handling mall admin-related requests.
 */
@RestController
@RequestMapping("/api/admins")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    /**
     * Create or update a mall admin.
     *
     * @param mallAdmin The mall admin to be created or updated.
     * @return ResponseEntity with the saved mall admin.
     */
    @PostMapping("/save")
    public ResponseEntity<MallAdmin> saveMallAdmin(@RequestBody MallAdmin mallAdmin) {
        return ResponseEntity.ok(mallAdminService.saveMallAdmin(mallAdmin));
    }
    
    /**
     * Fetch all mall admins.
     *
     * @return ResponseEntity with a list of all mall admins.
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<MallAdmin>> getAllMallAdmins() {
        return mallAdminService.findAllEmployees()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get a mall admin by ID.
     *
     * @param id The ID of the mall admin to retrieve.
     * @return ResponseEntity with the mall admin or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MallAdmin> getMallAdminById(@PathVariable Long id) {
        return mallAdminService.findMallAdminById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get mall admins by username containing a keyword.
     *
     * @param keyword The keyword to search for in usernames.
     * @return ResponseEntity with a list of mall admins whose username contains the keyword.
     */
    @GetMapping("/search/username/{keyword}")
    public ResponseEntity<List<MallAdmin>> getMallAdminsByUsernameContaining(@PathVariable String keyword) {
        return mallAdminService.findByUsernameContaining(keyword)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a mall admin by ID.
     *
     * @param id The ID of the mall admin to delete.
     * @return ResponseEntity with no content or a 404 status if the admin was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMallAdminById(@PathVariable Long id) {
        try {
            mallAdminService.deleteMallAdminById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
