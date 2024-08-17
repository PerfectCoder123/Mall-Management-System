package com.shop.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * Represents a shop within the system.
 * A shop has a name, location, category, and is associated with a shop owner and a list of employees.
 */
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the shop

    private String name; // Name of the shop
    private String location; // Location of the shop
    private String category; // Category of the shop

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>(); // List of employees working in the shop

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private ShopOwner shopOwner; // Shop owner associated with this shop
    
    /**
     * Default constructor.
     */
    public Shop() {}

    /**
     * Parameterized constructor for creating a new shop.
     *
     * @param name       the name of the shop
     * @param location   the location of the shop
     * @param category   the category of the shop
     * @param shopOwner  the shop owner associated with this shop
     */
    public Shop(String name, String location, String category, ShopOwner shopOwner) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.shopOwner = shopOwner;
    }

    /**
     * Gets the unique identifier of the shop.
     *
     * @return the unique identifier of the shop
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the shop.
     *
     * @param id the unique identifier of the shop
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the shop.
     *
     * @return the name of the shop
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the shop.
     *
     * @param name the name of the shop
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the location of the shop.
     *
     * @return the location of the shop
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the shop.
     *
     * @param location the location of the shop
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the category of the shop.
     *
     * @return the category of the shop
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the shop.
     *
     * @param category the category of the shop
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the list of employees working in the shop.
     *
     * @return the list of employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets the list of employees working in the shop.
     *
     * @param employees the list of employees
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Gets the shop owner associated with this shop.
     *
     * @return the shop owner
     */
    public ShopOwner getShopOwner() {
        return shopOwner;
    }

    /**
     * Sets the shop owner associated with this shop.
     *
     * @param shopOwner the shop owner
     */
    public void setShopOwner(ShopOwner shopOwner) {
        this.shopOwner = shopOwner;
    }
}
