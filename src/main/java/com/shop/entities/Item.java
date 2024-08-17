package com.shop.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an item in the shop.
 */
@Document(collection = "items")
public class Item {

    @Id
    private String id; // Unique identifier for the item

    private String name; // Name of the item
    private String description; // Description of the item
    private double price; // Price of the item
    private int quantity; // Quantity of the item available

    /**
     * Default constructor.
     */
    public Item() {}

    /**
     * Parameterized constructor for creating a new item.
     *
     * @param name        the name of the item
     * @param description the description of the item
     * @param price       the price of the item
     * @param quantity    the quantity of the item
     */
    public Item(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the unique identifier of the item.
     *
     * @return the unique identifier of the item
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the item.
     *
     * @param id the unique identifier of the item
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the item.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the item.
     *
     * @param description the description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the quantity of the item available.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item available.
     *
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
