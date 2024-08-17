package com.shop.entities;

import jakarta.persistence.Entity;

/**
 * Entity representing a customer in the system.
 * Extends the User entity to inherit common user properties.
 */
@Entity
public class Customer extends User {
    
    // Phone number of the customer
    private String phoneNumber;
    
    // Address of the customer
    private String address;

    /**
     * Default constructor for the Customer entity.
     */
    public Customer() {
        super();
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phoneNumber The phone number to set for the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the address of the customer.
     *
     * @return The address of the customer.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address The address to set for the customer.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
