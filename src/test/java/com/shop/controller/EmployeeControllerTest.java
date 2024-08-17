package com.shop.controller;

import com.shop.entities.Employee;
import com.shop.service.EmployeeService;
import com.shop.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private ShopService shopService;


    @Test
    public void testFetchAllEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setPosition("Manager");

        when(employeeService.findAllEmployees()).thenReturn(Optional.of(List.of(employee)));

        mockMvc.perform(get("/api/employees/fetch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].position").value("Manager"));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setPosition("Manager");

        when(employeeService.findEmployeeById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("Manager"));
    }

    @Test
    public void testGetEmployeeByIdNotFound() throws Exception {
        when(employeeService.findEmployeeById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetEmployeesByNameContaining() throws Exception {
        Employee employee = new Employee();
        employee.setPosition("Manager");

        when(employeeService.findByNameContaining("Jahid")).thenReturn(Optional.of(List.of(employee)));

        mockMvc.perform(get("/api/employees/search/name/Jahid"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].position").value("Manager"));
    }

    @Test
    public void testGetEmployeesByPosition() throws Exception {
        Employee employee = new Employee();
        employee.setPosition("Manager");

        when(employeeService.findByPosition("Manager")).thenReturn(Optional.of(List.of(employee)));

        mockMvc.perform(get("/api/employees/position/Manager"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].position").value("Manager"));
    }

    @Test
    public void testDeleteEmployeeById() throws Exception {
        doNothing().when(employeeService).deleteEmployeeById(1L);

        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isNoContent());
    }
}
