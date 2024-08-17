package com.shop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.shop.entities.Customer;
import com.shop.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setId(1L);
        customer.setUsername("Jahid Khan"); // Use the provided name
        customer.setPassword("password123");
        customer.setRole("CUSTOMER");
        customer.setPhoneNumber("9372571406"); // Use the provided phone number
        customer.setAddress("Chaitanya Palace"); // Use the provided address
    }

    @Test
    public void testSaveCustomer() throws Exception {
        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);

        mockMvc.perform(post("/api/customers/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customer)));
    }

    @Test
    public void testGetCustomer() throws Exception {
        List<Customer> customers = Arrays.asList(customer);
        when(customerService.findAllCustomers()).thenReturn(Optional.of(customers));

        mockMvc.perform(get("/api/customers/fetch"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customers)));
    }

    @Test
    public void testGetCustomerById() throws Exception {
        when(customerService.findCustomerById(1L)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customer)));
    }

    @Test
    public void testGetCustomersByPhoneNumber() throws Exception {
        List<Customer> customers = Arrays.asList(customer);
        when(customerService.findByPhoneNumberContaining("9372571406")).thenReturn(Optional.of(customers));

        mockMvc.perform(get("/api/customers/phone/9372571406"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customers)));
    }

    @Test
    public void testGetCustomersByAddressContaining() throws Exception {
        List<Customer> customers = Arrays.asList(customer);
        when(customerService.findByAddressContaining("Chaitanya Palace")).thenReturn(Optional.of(customers));

        mockMvc.perform(get("/api/customers/search/address/Chaitanya Palace"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(customers)));
    }

    @Test
    public void testDeleteCustomerById() throws Exception {
        doNothing().when(customerService).deleteCustomerById(1L);

        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isNoContent());
    }
}
