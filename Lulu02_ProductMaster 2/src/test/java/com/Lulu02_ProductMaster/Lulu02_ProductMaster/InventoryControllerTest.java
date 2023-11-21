package com.Lulu02_ProductMaster.Lulu02_ProductMaster;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Lulu02_ProductMaster.Lulu02_ProductMaster.controller.InventoryController;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Inventory;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.repo.InventoryRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class InventoryControllerTest {
 
    @InjectMocks

    private InventoryController inventoryController;
 
    @Mock

    private InventoryRepo inventoryRepo;
 
    private MockMvc mockMvc;
 
    @BeforeEach

    public void setUp() {

        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();

    }
 
    @Test

    public void testGetInventory() throws Exception {

        // Mock the behavior of the repository

        List<Inventory> inventoryList = Arrays.asList(new Inventory(), new Inventory());

        Mockito.when(inventoryRepo.findAll()).thenReturn(inventoryList);
 
        mockMvc.perform(MockMvcRequestBuilders.get("/api3/inventory/getInventory"))

               .andExpect(MockMvcResultMatchers.status().isOk());

    }
 
    @Test

    public void testCreateInventory() throws Exception {

        Inventory inventory = new Inventory();

        // Mock the behavior of the repository

        Mockito.when(inventoryRepo.save(inventory)).thenReturn(inventory);
 
        mockMvc.perform(MockMvcRequestBuilders.post("/api3/inventory/addInventory")

                .contentType(MediaType.APPLICATION_JSON)

                .content(new ObjectMapper().writeValueAsString(inventory)))

                .andExpect(MockMvcResultMatchers.status().isOk());

    }
 
    @Test

    public void testDeleteInventory() throws Exception {

        Integer id = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api3/inventory/deleteInventory/{id}", id))

               .andExpect(MockMvcResultMatchers.status().isOk());

    }
 
    @Test

    public void testUpdateInventory() throws Exception {

        Integer id = 1;

        Inventory existingInventory = new Inventory();

        Inventory updatedInventory = new Inventory();

        updatedInventory.setStock("yes");

        updatedInventory.setUnits(56);
 
        // Mock the behavior of the repository

        Mockito.when(inventoryRepo.findById(id)).thenReturn(Optional.of(existingInventory));

        Mockito.when(inventoryRepo.save(existingInventory)).thenReturn(existingInventory);
 
        mockMvc.perform(MockMvcRequestBuilders.put("/api3/inventory/updateInventory/{id}", id)

                .contentType(MediaType.APPLICATION_JSON)

                .content(new ObjectMapper().writeValueAsString(updatedInventory)))

                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
