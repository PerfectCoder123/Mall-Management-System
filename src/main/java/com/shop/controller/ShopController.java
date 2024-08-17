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

import com.shop.entities.Shop;
import com.shop.entities.ShopOwner;
import com.shop.service.ShopOwnerService;
import com.shop.service.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopOwnerService shopOwnerService;

    // Create or update a shop
    @PostMapping("/save")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.saveShop(shop));
    }

    // Fetch all shops
    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        return shopService.findAllShops()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        return shopService.findShopById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get shops by name containing keyword
    @GetMapping("/search/name/{keyword}")
    public ResponseEntity<List<Shop>> getShopsByNameContaining(@PathVariable String keyword) {
        return shopService.findByNameContaining(keyword)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get shops by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Shop>> getShopsByLocation(@PathVariable String location) {
        return shopService.findByLocation(location)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get shops by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Shop>> getShopsByCategory(@PathVariable String category) {
        return shopService.findByCategory(category)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get shops by shop owner ID
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Shop>> getShopsByShopOwner(@PathVariable Long ownerId) {
        Optional<ShopOwner> shopOwner = shopOwnerService.findShopOwnerById(ownerId);
        return shopOwner.flatMap(value -> shopService.findByShopOwner(value)
            .map(ResponseEntity::ok))
            .orElse(ResponseEntity.notFound().build());
    }

    // Delete a shop by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopById(@PathVariable Long id) {
        shopService.deleteShopById(id);
        return ResponseEntity.noContent().build();
    }
}
