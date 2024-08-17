package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entities.Employee;
import com.shop.entities.Shop;

/**
 * Repository interface for managing {@link Employee} entities.
 * Provides CRUD operations and custom query methods for accessing employee data.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Finds employees whose username contains the specified substring.
     *
     * @param name the substring to search for in usernames
     * @return a list of employees with usernames containing the specified substring
     */
    List<Employee> findByUsernameContaining(String name);

    /**
     * Finds employees with the specified position.
     *
     * @param position the position to search for
     * @return a list of employees with the specified position
     */
    List<Employee> findByPosition(String position);

    /**
     * Finds employees associated with the specified shop.
     *
     * @param shop the shop to search for employees
     * @return a list of employees working at the specified shop
     */
    List<Employee> findByShop(Shop shop);
}
