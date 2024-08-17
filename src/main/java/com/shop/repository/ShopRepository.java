package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.entities.Shop;
import com.shop.entities.ShopOwner;

/**
 * Repository interface for managing {@link Shop} entities.
 * Provides CRUD operations and custom query methods for accessing shop data.
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    /**
     * Finds shops whose name contains the specified substring.
     *
     * @param name the substring to search for in shop names
     * @return a list of shops with names containing the specified substring
     */
    List<Shop> findByNameContaining(String name);

    /**
     * Finds shops located at the specified location.
     *
     * @param location the location to search for
     * @return a list of shops located at the specified location
     */
    List<Shop> findByLocation(String location);

    /**
     * Finds shops that belong to the specified category.
     *
     * @param category the category to search for
     * @return a list of shops in the specified category
     */
    List<Shop> findByCategory(String category);

    /**
     * Finds shops that are owned by the specified shop owner.
     *
     * @param shopOwner the shop owner to search for
     * @return a list of shops owned by the specified shop owner
     */
    List<Shop> findByShopOwner(ShopOwner shopOwner);
}
