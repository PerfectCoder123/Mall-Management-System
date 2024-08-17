package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.ShopOwner;
import com.shop.repository.ShopOwnerRepository;

/**
 * Service class for managing {@link ShopOwner} entities.
 * Provides business logic and interacts with the {@link ShopOwnerRepository} for CRUD operations.
 */
@Service
public class ShopOwnerService {

    @Autowired
    private ShopOwnerRepository shopOwnerRepository;

    /**
     * Saves a shop owner entity.
     *
     * @param shopOwner the shop owner entity to save
     * @return the saved shop owner entity
     */
    public ShopOwner saveShopOwner(ShopOwner shopOwner) {
        return shopOwnerRepository.save(shopOwner);
    }

    /**
     * Finds a shop owner entity by its ID.
     *
     * @param id the ID of the shop owner to find
     * @return an {@link Optional} containing the shop owner with the specified ID, or empty if not found
     */
    public Optional<ShopOwner> findShopOwnerById(Long id) {
        return shopOwnerRepository.findById(id);
    }

    /**
     * Finds shop owners by the name of their shop.
     *
     * @param shopName the name of the shop to search for
     * @return a list of shop owners with the specified shop name
     */
    public List<ShopOwner> findByShopName(String shopName) {
        return shopOwnerRepository.findByShopName(shopName);
    }

    /**
     * Finds shop owners by the name of their shop, containing the specified keyword.
     *
     * @param keyword the keyword to search for in shop names
     * @return a list of shop owners with shop names containing the specified keyword
     */
    public List<ShopOwner> findByShopNameContaining(String keyword) {
        return shopOwnerRepository.findByShopNameContaining(keyword);
    }

    /**
     * Deletes a shop owner entity by its ID.
     *
     * @param id the ID of the shop owner to delete
     */
    public void deleteShopOwnerById(Long id) {
        shopOwnerRepository.deleteById(id);
    }
   
    /**
     * Retrieves all shop owner entities.
     *
     * @return an {@link Optional} containing a list of all shop owners
     */
    public Optional<List<ShopOwner>> findAllShopOwners() {
        List<ShopOwner> shopOwners = shopOwnerRepository.findAll();
        return Optional.of(shopOwners);
    }
}
