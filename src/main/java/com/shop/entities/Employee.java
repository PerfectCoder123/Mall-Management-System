package com.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entity representing an employee in the system.
 * Extends the User entity to inherit common user properties.
 */
@Entity
public class Employee extends User {

    // Position of the employee in the shop
    private String position;
    
    // Phone number of the employee
    private String phoneNumber;

    // Shop where the employee works
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = true)
    @JsonBackReference
    private Shop shop;

    /**
     * Default constructor for the Employee entity.
     */
    public Employee() {}

    /**
     * Gets the position of the employee.
     *
     * @return The position of the employee.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position of the employee.
     *
     * @param position The position to set for the employee.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets the phone number of the employee.
     *
     * @return The phone number of the employee.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the employee.
     *
     * @param phoneNumber The phone number to set for the employee.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the shop where the employee works.
     *
     * @return The shop where the employee works.
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Sets the shop where the employee works.
     *
     * @param shop The shop to set for the employee.
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
