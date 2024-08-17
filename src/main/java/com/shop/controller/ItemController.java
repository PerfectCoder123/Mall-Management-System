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
import com.shop.entities.Item;
import com.shop.service.ItemService;

/**
 * Controller for handling item-related requests.
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Create or update an item.
     *
     * @param item The item to be created or updated.
     * @return ResponseEntity with the saved item.
     */
    @PostMapping(value = "/save")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    /**
     * Get an item by ID.
     *
     * @param id The ID of the item to retrieve.
     * @return ResponseEntity with the item or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        return itemService.findItemById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get items by name containing a keyword.
     *
     * @param keyword The keyword to search for in item names.
     * @return ResponseEntity with a list of items whose name contains the keyword.
     */
    @GetMapping("/search/name/{keyword}")
    public ResponseEntity<List<Item>> getItemsByNameContaining(@PathVariable String keyword) {
        return ResponseEntity.ok(itemService.findByNameContaining(keyword));
    }

    /**
     * Get items by price less than or equal to a certain amount.
     *
     * @param price The maximum price of items to retrieve.
     * @return ResponseEntity with a list of items priced less than or equal to the specified amount.
     */
    @GetMapping("/search/price/{price}")
    public ResponseEntity<List<Item>> getItemsByPriceLessThanEqual(@PathVariable double price) {
        return ResponseEntity.ok(itemService.findByPriceLessThanEqual(price));
    }

    /**
     * Delete an item by ID.
     *
     * @param id The ID of the item to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
