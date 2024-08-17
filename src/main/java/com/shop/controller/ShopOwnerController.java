package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entities.ShopOwner;
import com.shop.service.ShopOwnerService;

/**
 * Controller for handling shop owner-related requests.
 */
@RestController
@RequestMapping("/api/shop-owners")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService shopOwnerService;

    /**
     * Create or update a shop owner.
     *
     * @param shopOwner The shop owner to be created or updated.
     * @return ResponseEntity with the saved shop owner.
     */
    @PostMapping("/save")
    public ResponseEntity<ShopOwner> saveShopOwner(@RequestBody ShopOwner shopOwner) {
        return ResponseEntity.ok(shopOwnerService.saveShopOwner(shopOwner));
    }

    /**
     * Fetch all shop owners.
     *
     * @return ResponseEntity with a list of all shop owners or no content if none are found.
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<ShopOwner>> getAllShopOwners() {
        Optional<List<ShopOwner>> shopOwners = shopOwnerService.findAllShopOwners();
        return shopOwners
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Get a shop owner by ID.
     *
     * @param id The ID of the shop owner to retrieve.
     * @return ResponseEntity with the shop owner or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> getShopOwnerById(@PathVariable Long id) {
        return shopOwnerService.findShopOwnerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get shop owners by shop name.
     *
     * @param shopName The name of the shop to search for shop owners.
     * @return ResponseEntity with a list of shop owners for the given shop name.
     */
    @GetMapping("/shop-name/{shopName}")
    public ResponseEntity<List<ShopOwner>> getShopOwnersByShopName(@PathVariable String shopName) {
        return ResponseEntity.ok(shopOwnerService.findByShopName(shopName));
    }

    /**
     * Get shop owners by shop name containing a keyword.
     *
     * @param keyword The keyword to search for in shop names.
     * @return ResponseEntity with a list of shop owners where the shop name contains the keyword.
     */
    @GetMapping("/search/shop-name/{keyword}")
    public ResponseEntity<List<ShopOwner>> getShopOwnersByShopNameContaining(@PathVariable String keyword) {
        return ResponseEntity.ok(shopOwnerService.findByShopNameContaining(keyword));
    }

    /**
     * Delete a shop owner by ID.
     *
     * @param id The ID of the shop owner to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopOwnerById(@PathVariable Long id) {
        shopOwnerService.deleteShopOwnerById(id);
        return ResponseEntity.noContent().build();
    }
}
