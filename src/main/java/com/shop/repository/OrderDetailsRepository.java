package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.entities.Customer;
import com.shop.entities.OrderDetails;
import com.shop.entities.ShopOwner;

/**
 * Repository interface for managing {@link OrderDetails} entities.
 * Provides CRUD operations and custom query methods for accessing order details data.
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * Finds order details associated with the specified customer.
     *
     * @param customer the customer to search for
     * @return a list of order details associated with the specified customer
     */
    List<OrderDetails> findByCustomer(Customer customer);

    /**
     * Finds order details associated with the specified shop owner.
     *
     * @param shopOwner the shop owner to search for
     * @return a list of order details associated with the specified shop owner
     */
    List<OrderDetails> findByShopOwner(ShopOwner shopOwner);

    /**
     * Finds order details with the specified product name.
     *
     * @param productName the product name to search for
     * @return a list of order details with the specified product name
     */
    List<OrderDetails> findByProductName(String productName);

    /**
     * Finds order details where the product name contains the specified keyword.
     *
     * @param keyword the substring to search for in product names
     * @return a list of order details with product names containing the specified keyword
     */
    List<OrderDetails> findByProductNameContaining(String keyword);

    /**
     * Finds order details with a product name that matches the specified product name, ignoring case.
     *
     * @param productName the product name to search for, case insensitive
     * @return a list of order details with product names matching the specified product name, ignoring case
     */
    List<OrderDetails> findByProductNameIgnoreCase(String productName);

    /**
     * Finds order details where the quantity is greater than or equal to the specified amount.
     *
     * @param quantity the minimum quantity to search for
     * @return a list of order details with quantities greater than or equal to the specified amount
     */
    List<OrderDetails> findByQuantityGreaterThanEqual(int quantity);

    /**
     * Finds order details where the price is between the specified minimum and maximum prices.
     *
     * @param minPrice the minimum price to search for
     * @param maxPrice the maximum price to search for
     * @return a list of order details with prices between the specified minimum and maximum prices
     */
    List<OrderDetails> findByPriceBetween(double minPrice, double maxPrice);
}
