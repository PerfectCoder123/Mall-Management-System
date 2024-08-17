package com.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.shop.entities.Item;
import java.util.List;

/**
 * Repository interface for managing {@link Item} entities in MongoDB.
 * Provides CRUD operations and custom query methods for accessing item data.
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    /**
     * Finds items whose name contains the specified substring.
     *
     * @param name the substring to search for in item names
     * @return a list of items with names containing the specified substring
     */
    List<Item> findByNameContaining(String name);

    /**
     * Finds items with a price less than or equal to the specified amount.
     *
     * @param price the maximum price to search for
     * @return a list of items with prices less than or equal to the specified amount
     */
    List<Item> findByPriceLessThanEqual(double price);
}
