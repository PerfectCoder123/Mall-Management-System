package com.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents the details of an order placed by a customer.
 * Includes information about the customer, shop owner, product, quantity, and price.
 */
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the order details

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Customer who placed the order

    @ManyToOne
    @JoinColumn(name = "shop_owner_id")
    private ShopOwner shopOwner; // Shop owner who manages the shop where the order was placed

    private String productName; // Name of the product ordered
    private int quantity; // Quantity of the product ordered
    private double price; // Price of the product ordered
    
    /**
     * Default constructor.
     */
    public OrderDetails() {
        super();
    }

    /**
     * Gets the unique identifier of the order details.
     *
     * @return the unique identifier of the order details
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the order details.
     *
     * @param id the unique identifier of the order details
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the customer who placed the order.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer who placed the order.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the shop owner who manages the shop where the order was placed.
     *
     * @return the shop owner
     */
    public ShopOwner getShopOwner() {
        return shopOwner;
    }

    /**
     * Sets the shop owner who manages the shop where the order was placed.
     *
     * @param shopOwner the shop owner
     */
    public void setShopOwner(ShopOwner shopOwner) {
        this.shopOwner = shopOwner;
    }

    /**
     * Gets the name of the product ordered.
     *
     * @return the name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product ordered.
     *
     * @param productName the name of the product
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the quantity of the product ordered.
     *
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product ordered.
     *
     * @param quantity the quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the product ordered.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product ordered.
     *
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
