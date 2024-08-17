package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.Customer;
import com.shop.repository.CustomerRepository;

/**
 * Service class for managing {@link Customer} entities.
 * Provides business logic and interacts with the {@link CustomerRepository} for CRUD operations.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Saves a customer entity.
     *
     * @param customer the customer entity to save
     * @return the saved customer entity
     */
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Finds a customer by their ID.
     *
     * @param id the ID of the customer to find
     * @return an {@link Optional} containing the customer with the specified ID, or empty if not found
     */
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Finds customers whose phone number contains the specified substring.
     *
     * @param phoneNumber the substring to search for in phone numbers
     * @return an {@link Optional} containing a list of customers with phone numbers containing the specified substring,
     *         or empty if no such customers are found
     */
    public Optional<List<Customer>> findByPhoneNumberContaining(String phoneNumber) {
        List<Customer> customers = customerRepository.findByPhoneNumberContaining(phoneNumber);
        return customers.isEmpty() ? Optional.empty() : Optional.of(customers);
    }

    /**
     * Finds customers whose address contains the specified keyword.
     *
     * @param keyword the substring to search for in addresses
     * @return an {@link Optional} containing a list of customers with addresses containing the specified keyword,
     *         or empty if no such customers are found
     */
    public Optional<List<Customer>> findByAddressContaining(String keyword) {
        List<Customer> customers = customerRepository.findByAddressContaining(keyword);
        return customers.isEmpty() ? Optional.empty() : Optional.of(customers);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     */
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
    
    /**
     * Finds all customers.
     *
     * @return an {@link Optional} containing a list of all customers, or empty if no customers are found
     */
    public Optional<List<Customer>> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.isEmpty() ? Optional.empty() : Optional.of(customers);
    }
}
