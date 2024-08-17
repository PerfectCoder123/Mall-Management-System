package com.shop.controller;

import java.util.List;
import java.util.Optional;

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
import com.shop.entities.OrderDetails;
import com.shop.entities.ShopOwner;
import com.shop.service.CustomerService;
import com.shop.service.OrderDetailsService;
import com.shop.service.ShopOwnerService;

/**
 * Controller for handling order details-related requests.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ShopOwnerService shopOwnerService;

    /**
     * Create or update an order.
     *
     * @param orderDetails The order details to be created or updated.
     * @return ResponseEntity with the saved order details.
     */
    @PostMapping("/save")
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails orderDetails) {
        return ResponseEntity.ok(orderDetailsService.saveOrderDetails(orderDetails));
    }

    /**
     * Fetch all order details.
     *
     * @return ResponseEntity with a list of all order details or no content if none are found.
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        Optional<List<OrderDetails>> orders = orderDetailsService.getAllOrderDetails();
        return orders.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Get order details by ID.
     *
     * @param id The ID of the order to retrieve.
     * @return ResponseEntity with the order details or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderById(@PathVariable Long id) {
        return orderDetailsService.findOrderById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get orders by customer ID.
     *
     * @param customerId The ID of the customer to retrieve orders for.
     * @return ResponseEntity with a list of orders for the customer or a 404 status if the customer is not found.
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDetails>> getOrdersByCustomer(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.findCustomerById(customerId);
        if (customer.isPresent()) {
            Optional<List<OrderDetails>> orders = orderDetailsService.findOrdersByCustomer(customer.get());
            return orders.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.noContent().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get orders by shop owner ID.
     *
     * @param shopOwnerId The ID of the shop owner to retrieve orders for.
     * @return ResponseEntity with a list of orders for the shop owner or a 404 status if the shop owner is not found.
     */
    @GetMapping("/shop-owner/{shopOwnerId}")
    public ResponseEntity<List<OrderDetails>> getOrdersByShopOwner(@PathVariable Long shopOwnerId) {
        Optional<ShopOwner> shopOwner = shopOwnerService.findShopOwnerById(shopOwnerId);
        if (shopOwner.isPresent()) {
            Optional<List<OrderDetails>> orders = orderDetailsService.findOrdersByShopOwner(shopOwner.get());
            return orders.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.noContent().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get orders by product name containing a keyword.
     *
     * @param keyword The keyword to search for in product names.
     * @return ResponseEntity with a list of orders where the product name contains the keyword.
     */
    @GetMapping("/search/product/{keyword}")
    public ResponseEntity<List<OrderDetails>> getOrdersByProductNameContaining(@PathVariable String keyword) {
        Optional<List<OrderDetails>> orders = orderDetailsService.findByProductNameContaining(keyword);
        return orders.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Delete an order by ID.
     *
     * @param id The ID of the order to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderDetailsService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
