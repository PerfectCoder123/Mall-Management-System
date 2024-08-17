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

import com.shop.entities.Employee;
import com.shop.entities.Shop;
import com.shop.service.EmployeeService;
import com.shop.service.ShopService;

/**
 * Controller for handling employee-related requests.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ShopService shopService;

    /**
     * Create or update an employee.
     *
     * @param employee The employee to be created or updated.
     * @return ResponseEntity with the saved employee.
     */
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    
    /**
     * Fetch all employees.
     *
     * @return ResponseEntity with a list of all employees.
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<Employee>> fetchAllEmployees() {
        return employeeService.findAllEmployees()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get an employee by ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return ResponseEntity with the employee or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get employees by name containing a keyword.
     *
     * @param keyword The keyword to search for in employee names.
     * @return ResponseEntity with a list of employees whose name contains the keyword.
     */
    @GetMapping("/search/name/{keyword}")
    public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@PathVariable String keyword) {
        return employeeService.findByNameContaining(keyword)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get employees by their position.
     *
     * @param position The position to search for.
     * @return ResponseEntity with a list of employees in the specified position.
     */
    @GetMapping("/position/{position}")
    public ResponseEntity<List<Employee>> getEmployeesByPosition(@PathVariable String position) {
        return employeeService.findByPosition(position)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get employees by shop ID.
     *
     * @param shopId The ID of the shop to retrieve employees for.
     * @return ResponseEntity with a list of employees associated with the shop, or a 404 status if not found.
     */
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Employee>> getEmployeesByShop(@PathVariable Long shopId) {
        Optional<Shop> shop = shopService.findShopById(shopId);
        return shop.flatMap(value -> employeeService.findByShop(value)
            .map(ResponseEntity::ok))
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete an employee by ID.
     *
     * @param id The ID of the employee to delete.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
}
