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
import com.shop.entities.Customer;
import com.shop.service.CustomerService;

/**
 * Controller for handling customer-related requests.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Create or update a customer.
     *
     * @param customer The customer to be created or updated.
     * @return ResponseEntity with the saved customer.
     */
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }
    
    /**
     * Get all customers.
     *
     * @return ResponseEntity with a list of all customers.
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<Customer>> getCustomer() {
        return customerService.findAllCustomers()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get a customer by ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return ResponseEntity with the customer or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get customers by phone number.
     *
     * @param phoneNumber The phone number to search for.
     * @return ResponseEntity with a list of customers matching the phone number.
     */
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<List<Customer>> getCustomersByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.findByPhoneNumberContaining(phoneNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get customers by address containing a keyword.
     *
     * @param keyword The keyword to search for in addresses.
     * @return ResponseEntity with a list of customers whose address contains the keyword.
     */
    @GetMapping("/search/address/{keyword}")
    public ResponseEntity<List<Customer>> getCustomersByAddressContaining(@PathVariable String keyword) {
        return customerService.findByAddressContaining(keyword)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a customer by ID.
     *
     * @param id The ID of the customer to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
