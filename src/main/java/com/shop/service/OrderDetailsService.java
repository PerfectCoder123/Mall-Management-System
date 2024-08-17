package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.Customer;
import com.shop.entities.OrderDetails;
import com.shop.entities.ShopOwner;
import com.shop.repository.OrderDetailsRepository;

/**
 * Service class for managing {@link OrderDetails} entities.
 * Provides business logic and interacts with the {@link OrderDetailsRepository} for CRUD operations.
 */
@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    /**
     * Saves an order details entity.
     *
     * @param orderDetails the order details entity to save
     * @return the saved order details entity
     */
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    /**
     * Finds an order details entity by its ID.
     *
     * @param id the ID of the order details to find
     * @return an {@link Optional} containing the order details with the specified ID, or empty if not found
     */
    public Optional<OrderDetails> findOrderById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    /**
     * Finds orders associated with a specific customer.
     *
     * @param customer the customer whose orders are to be found
     * @return an {@link Optional} containing a list of orders associated with the specified customer,
     *         or empty if no such orders are found
     */
    public Optional<List<OrderDetails>> findOrdersByCustomer(Customer customer) {
        List<OrderDetails> orders = orderDetailsRepository.findByCustomer(customer);
        return orders.isEmpty() ? Optional.empty() : Optional.of(orders);
    }

    /**
     * Finds orders associated with a specific shop owner.
     *
     * @param shopOwner the shop owner whose orders are to be found
     * @return an {@link Optional} containing a list of orders associated with the specified shop owner,
     *         or empty if no such orders are found
     */
    public Optional<List<OrderDetails>> findOrdersByShopOwner(ShopOwner shopOwner) {
        List<OrderDetails> orders = orderDetailsRepository.findByShopOwner(shopOwner);
        return orders.isEmpty() ? Optional.empty() : Optional.of(orders);
    }

    /**
     * Finds orders where the product name contains the specified keyword.
     *
     * @param keyword the keyword to search for in product names
     * @return an {@link Optional} containing a list of orders where the product name contains the specified keyword,
     *         or empty if no such orders are found
     */
    public Optional<List<OrderDetails>> findByProductNameContaining(String keyword) {
        List<OrderDetails> orders = orderDetailsRepository.findByProductNameContaining(keyword);
        return orders.isEmpty() ? Optional.empty() : Optional.of(orders);
    }

    /**
     * Deletes an order details entity by its ID.
     *
     * @param id the ID of the order details to delete
     */
    public void deleteOrderById(Long id) {
        orderDetailsRepository.deleteById(id);
    }
    
    /**
     * Retrieves all order details entities.
     *
     * @return an {@link Optional} containing a list of all order details,
     *         or empty if no order details are found
     */
    public Optional<List<OrderDetails>> getAllOrderDetails() {
        List<OrderDetails> orders = orderDetailsRepository.findAll();
        return orders.isEmpty() ? Optional.empty() : Optional.of(orders);
    }
}
