package com.shop.controller;

import com.shop.entities.Item;
import com.shop.service.ItemService;
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

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void testSaveItem() throws Exception {
        Item item = new Item("Laptop", "Electronics", 1000.00, 10);

        when(itemService.saveItem(any(Item.class))).thenReturn(item);

        mockMvc.perform(post("/api/items/save")
                .contentType("application/json")
                .content("{\"name\": \"Laptop\", \"description\": \"Electronics\", \"price\": 1000.00, \"quantity\": 10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    public void testGetItemById() throws Exception {
        Item item = new Item("Laptop", "Electronics", 1000.00, 10);
        item.setId("1");

        when(itemService.findItemById("1")).thenReturn(Optional.of(item));

        mockMvc.perform(get("/api/items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    public void testGetItemByIdNotFound() throws Exception {
        when(itemService.findItemById("1")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/items/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetItemsByNameContaining() throws Exception {
        Item item = new Item("Laptop", "Electronics", 1000.00, 10);

        when(itemService.findByNameContaining("Lap")).thenReturn(List.of(item));

        mockMvc.perform(get("/api/items/search/name/Lap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }

    @Test
    public void testGetItemsByPriceLessThanEqual() throws Exception {
        Item item = new Item("Laptop", "Electronics", 1000.00, 10);

        when(itemService.findByPriceLessThanEqual(1000.00)).thenReturn(List.of(item));

        mockMvc.perform(get("/api/items/search/price/1000.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(1000.00));
    }

    @Test
    public void testDeleteItemById() throws Exception {
        doNothing().when(itemService).deleteItemById("1");

        mockMvc.perform(delete("/api/items/1"))
                .andExpect(status().isNoContent());
    }
}

