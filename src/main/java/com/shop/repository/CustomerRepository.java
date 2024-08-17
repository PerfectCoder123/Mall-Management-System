package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entities.Customer;

/**
 * Repository interface for managing {@link Customer} entities.
 * Provides CRUD operations and custom query methods for accessing customer data.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds customers whose phone number contains the specified substring.
     *
     * @param phoneNumber the substring to search for in phone numbers
     * @return a list of customers with phone numbers containing the specified substring
     */
    List<Customer> findByPhoneNumberContaining(String phoneNumber);

    /**
     * Finds customers whose address contains the specified keyword.
     *
     * @param keyword the keyword to search for in addresses
     * @return a list of customers with addresses containing the specified keyword
     */
    List<Customer> findByAddressContaining(String keyword);

    /**
     * Finds customers with an exact match for the specified address.
     *
     * @param address the address to search for
     * @return a list of customers with the specified address
     */
    List<Customer> findByAddress(String address);

    /**
     * Finds customers with an address that matches the specified address, ignoring case.
     *
     * @param address the address to search for, case insensitive
     * @return a list of customers with addresses that match the specified address, ignoring case
     */
    List<Customer> findByAddressIgnoreCase(String address);
}
