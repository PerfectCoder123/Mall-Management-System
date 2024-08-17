package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entities.Employee;
import com.shop.entities.Shop;
import com.shop.repository.EmployeeRepository;

/**
 * Service class for managing {@link Employee} entities.
 * Provides business logic and interacts with the {@link EmployeeRepository} for CRUD operations.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Saves an employee entity.
     *
     * @param employee the employee entity to save
     * @return the saved employee entity
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Finds an employee by their ID.
     *
     * @param id the ID of the employee to find
     * @return an {@link Optional} containing the employee with the specified ID, or empty if not found
     */
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Finds employees whose username contains the specified substring.
     *
     * @param name the substring to search for in usernames
     * @return an {@link Optional} containing a list of employees with usernames containing the specified substring,
     *         or empty if no such employees are found
     */
    public Optional<List<Employee>> findByNameContaining(String name) {
        List<Employee> employees = employeeRepository.findByUsernameContaining(name);
        return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
    }

    /**
     * Finds employees with the specified position.
     *
     * @param position the position to search for
     * @return an {@link Optional} containing a list of employees with the specified position,
     *         or empty if no such employees are found
     */
    public Optional<List<Employee>> findByPosition(String position) {
        List<Employee> employees = employeeRepository.findByPosition(position);
        return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
    }

    /**
     * Finds employees associated with the specified shop.
     *
     * @param shop the shop to search for
     * @return an {@link Optional} containing a list of employees associated with the specified shop,
     *         or empty if no such employees are found
     */
    public Optional<List<Employee>> findByShop(Shop shop) {
        List<Employee> employees = employeeRepository.findByShop(shop);
        return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     */
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
    
    /**
     * Finds all employees.
     *
     * @return an {@link Optional} containing a list of all employees, or empty if no employees are found
     */
    public Optional<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
    }
}
