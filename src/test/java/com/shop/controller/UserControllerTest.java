package com.shop.controller;

import com.shop.entities.User;
import com.shop.service.UserService;
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

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setId(1L);

        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users/save")
                .contentType("application/json")
                .content("{\"id\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1L);

        when(userService.findUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testGetUserByIdNotFound() throws Exception {
        when(userService.findUserById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        User user = new User();
        user.setUsername("john_doe");

        when(userService.findByUsername("john_doe")).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/username/john_doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe"));
    }

    @Test
    public void testGetUserByUsernameNotFound() throws Exception {
        when(userService.findByUsername("john_doe")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/username/john_doe"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetUsersByRole() throws Exception {
        User user = new User();
        user.setRole("ADMIN");

        when(userService.findByRole("ADMIN")).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users/role/ADMIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].role").value("ADMIN"));
    }

    @Test
    public void testGetUsersByUsernameContaining() throws Exception {
        User user = new User();
        user.setUsername("john_doe");

        when(userService.findByUsernameContaining("john")).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users/search/username/john"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("john_doe"));
    }

    @Test
    public void testDeleteUserById() throws Exception {
        doNothing().when(userService).deleteUserById(1L);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}
