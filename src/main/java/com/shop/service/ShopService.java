package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.Employee;
import com.shop.entities.Shop;
import com.shop.entities.ShopOwner;
import com.shop.repository.EmployeeRepository;
import com.shop.repository.ShopRepository;

/**
 * Service class for managing {@link Shop} entities.
 * Provides business logic and interacts with the {@link ShopRepository} and {@link EmployeeRepository} for CRUD operations.
 */
@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Saves a shop entity and its associated employees.
     *
     * @param shop the shop entity to save
     * @return the saved shop entity
     */
    public Shop saveShop(Shop shop) {
        Shop savedShop = shopRepository.save(shop);

        // If the shop has employees, set their shop reference and save them
        if (shop.getEmployees() != null) {
            for (Employee employee : shop.getEmployees()) {
                employee.setShop(savedShop);
                employeeRepository.save(employee);
            }
        }
       
        return savedShop;
    }

    /**
     * Finds a shop entity by its ID.
     *
     * @param id the ID of the shop to find
     * @return an {@link Optional} containing the shop with the specified ID, or empty if not found
     */
    public Optional<Shop> findShopById(Long id) {
        return shopRepository.findById(id);
    }

    /**
     * Finds shops whose names contain the specified keyword.
     *
     * @param name the keyword to search for in shop names
     * @return an {@link Optional} containing a list of shops with names containing the specified keyword, or empty if none found
     */
    public Optional<List<Shop>> findByNameContaining(String name) {
        List<Shop> shops = shopRepository.findByNameContaining(name);
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops);
    }

    /**
     * Finds shops located in the specified location.
     *
     * @param location the location of the shops to search for
     * @return an {@link Optional} containing a list of shops located in the specified location, or empty if none found
     */
    public Optional<List<Shop>> findByLocation(String location) {
        List<Shop> shops = shopRepository.findByLocation(location);
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops);
    }

    /**
     * Finds shops in the specified category.
     *
     * @param category the category of the shops to search for
     * @return an {@link Optional} containing a list of shops in the specified category, or empty if none found
     */
    public Optional<List<Shop>> findByCategory(String category) {
        List<Shop> shops = shopRepository.findByCategory(category);
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops);
    }

    /**
     * Finds shops owned by the specified shop owner.
     *
     * @param shopOwner the shop owner of the shops to search for
     * @return an {@link Optional} containing a list of shops owned by the specified shop owner, or empty if none found
     */
    public Optional<List<Shop>> findByShopOwner(ShopOwner shopOwner) {
        List<Shop> shops = shopRepository.findByShopOwner(shopOwner);
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops);
    }

    /**
     * Deletes a shop entity by its ID.
     *
     * @param id the ID of the shop to delete
     */
    public void deleteShopById(Long id) {
        shopRepository.deleteById(id);
    }

    /**
     * Finds all shop entities.
     *
     * @return an {@link Optional} containing a list of all shops, or empty if no shops exist
     */
    public Optional<List<Shop>> findAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops);
    }
}
