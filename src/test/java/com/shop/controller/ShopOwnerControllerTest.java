package com.shop.controller;

import com.shop.entities.ShopOwner;
import com.shop.service.ShopOwnerService;
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

@WebMvcTest(ShopOwnerController.class)
public class ShopOwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShopOwnerService shopOwnerService;

    @Test
    public void testGetAllShopOwners() throws Exception {
        ShopOwner shopOwner = new ShopOwner();
        shopOwner.setId(1L);

        when(shopOwnerService.findAllShopOwners()).thenReturn(Optional.of(List.of(shopOwner)));

        mockMvc.perform(get("/api/shop-owners/fetch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    public void testGetAllShopOwnersNoContent() throws Exception {
        when(shopOwnerService.findAllShopOwners()).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/shop-owners/fetch"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetShopOwnerById() throws Exception {
        ShopOwner shopOwner = new ShopOwner();
        shopOwner.setId(1L);

        when(shopOwnerService.findShopOwnerById(1L)).thenReturn(Optional.of(shopOwner));

        mockMvc.perform(get("/api/shop-owners/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testGetShopOwnerByIdNotFound() throws Exception {
        when(shopOwnerService.findShopOwnerById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/shop-owners/1"))
                .andExpect(status().isNotFound());
    }



    @Test
    public void testGetShopOwnersByShopNameContaining() throws Exception {
        ShopOwner shopOwner = new ShopOwner();
        shopOwner.setId(1L);

        when(shopOwnerService.findByShopNameContaining("Tech")).thenReturn(List.of(shopOwner));

        mockMvc.perform(get("/api/shop-owners/search/shop-name/Tech"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    public void testDeleteShopOwnerById() throws Exception {
        doNothing().when(shopOwnerService).deleteShopOwnerById(1L);

        mockMvc.perform(delete("/api/shop-owners/1"))
                .andExpect(status().isNoContent());
    }
}
