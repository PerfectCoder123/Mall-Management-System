package com.shop.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

/**
 * Represents a shop owner, which is a specialized type of user.
 * A shop owner has a shop name and a list of shops they own.
 */
@Entity
public class ShopOwner extends User {
    
    private String shopName; // Name of the shop owned by the shop owner
    
    @OneToMany(mappedBy = "shopOwner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Shop> shops = new ArrayList<>(); // List of shops owned by the shop owner

    /**
     * Default constructor.
     */
    public ShopOwner() {
        super();
    }

    /**
     * Gets the name of the shop owned by the shop owner.
     *
     * @return the name of the shop
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Sets the name of the shop owned by the shop owner.
     *
     * @param shopName the name of the shop
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    
    /**
     * Gets the list of shops owned by the shop owner.
     *
     * @return the list of shops
     */
    public List<Shop> getShops() {
        return shops;
    }

    /**
     * Sets the list of shops owned by the shop owner.
     *
     * @param shops the list of shops
     */
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
