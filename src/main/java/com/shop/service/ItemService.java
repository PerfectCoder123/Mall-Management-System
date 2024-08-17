package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.Item;
import com.shop.repository.ItemRepository;

/**
 * Service class for managing {@link Item} entities.
 * Provides business logic and interacts with the {@link ItemRepository} for CRUD operations.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Saves an item entity.
     *
     * @param item the item entity to save
     * @return the saved item entity
     */
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Finds an item by its ID.
     *
     * @param id the ID of the item to find
     * @return an {@link Optional} containing the item with the specified ID, or empty if not found
     */
    public Optional<Item> findItemById(String id) {
        return itemRepository.findById(id);
    }

    /**
     * Finds items whose name contains the specified substring.
     *
     * @param name the substring to search for in item names
     * @return a list of items with names containing the specified substring
     */
    public List<Item> findByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }

    /**
     * Finds items with a price less than or equal to the specified price.
     *
     * @param price the maximum price to search for
     * @return a list of items with a price less than or equal to the specified price
     */
    public List<Item> findByPriceLessThanEqual(double price) {
        return itemRepository.findByPriceLessThanEqual(price);
    }

    /**
     * Deletes an item by its ID.
     *
     * @param id the ID of the item to delete
     */
    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
