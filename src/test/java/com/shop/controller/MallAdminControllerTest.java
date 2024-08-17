package com.shop.controller;

import com.shop.entities.MallAdmin;
import com.shop.service.MallAdminService;
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

@WebMvcTest(MallAdminController.class)
public class MallAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MallAdminService mallAdminService;

    @Test
    public void testSaveMallAdmin() throws Exception {
        MallAdmin mallAdmin = new MallAdmin();

        when(mallAdminService.saveMallAdmin(any(MallAdmin.class))).thenReturn(mallAdmin);

        mockMvc.perform(post("/api/admins/save")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllMallAdmins() throws Exception {
        MallAdmin mallAdmin = new MallAdmin();

        when(mallAdminService.findAllEmployees()).thenReturn(Optional.of(List.of(mallAdmin)));

        mockMvc.perform(get("/api/admins/fetch"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMallAdminById() throws Exception {
        MallAdmin mallAdmin = new MallAdmin();
        mallAdmin.setId(1L);

        when(mallAdminService.findMallAdminById(1L)).thenReturn(Optional.of(mallAdmin));

        mockMvc.perform(get("/api/admins/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testGetMallAdminByIdNotFound() throws Exception {
        when(mallAdminService.findMallAdminById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/admins/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteMallAdminById() throws Exception {
        doNothing().when(mallAdminService).deleteMallAdminById(1L);

        mockMvc.perform(delete("/api/admins/1"))
                .andExpect(status().isNoContent());
    }
}
