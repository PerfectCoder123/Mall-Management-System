package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entities.ShopOwner;

/**
 * Repository interface for managing {@link ShopOwner} entities.
 * Provides CRUD operations and custom query methods for accessing shop owner data.
 */
public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {

    /**
     * Finds shop owners with the specified shop name.
     *
     * @param shopName the shop name to search for
     * @return a list of shop owners with the specified shop name
     */
    List<ShopOwner> findByShopName(String shopName);

    /**
     * Finds shop owners whose shop name contains the specified keyword.
     *
     * @param keyword the substring to search for in shop names
     * @return a list of shop owners with shop names containing the specified keyword
     */
    List<ShopOwner> findByShopNameContaining(String keyword);

    /**
     * Finds shop owners whose shop name starts with the specified prefix.
     *
     * @param prefix the prefix to search for in shop names
     * @return a list of shop owners with shop names starting with the specified prefix
     */
    List<ShopOwner> findByShopNameStartingWith(String prefix);

    /**
     * Finds shop owners whose shop name ends with the specified suffix.
     *
     * @param suffix the suffix to search for in shop names
     * @return a list of shop owners with shop names ending with the specified suffix
     */
    List<ShopOwner> findByShopNameEndingWith(String suffix);

    /**
     * Finds shop owners with a shop name that matches the specified shop name, ignoring case.
     *
     * @param shopName the shop name to search for, case insensitive
     * @return a list of shop owners with shop names matching the specified shop name, ignoring case
     */
    List<ShopOwner> findByShopNameIgnoreCase(String shopName);
}
