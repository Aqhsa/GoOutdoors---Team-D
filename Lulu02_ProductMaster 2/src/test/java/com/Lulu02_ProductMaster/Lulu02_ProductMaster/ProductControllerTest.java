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

import com.Lulu02_ProductMaster.Lulu02_ProductMaster.controller.ProductController;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Product;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.repo.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductControllerTest {
	@InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepo productRepo;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetJPQL() throws Exception {
        // Mock the behavior of the repository
        List<Product> productList = Arrays.asList(new Product(), new Product());
        Mockito.when(productRepo.findAll()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api3/product/getProduct"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product();

        // Mock the behavior of the repository
        Mockito.when(productRepo.save(product)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/api3/product/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testkct() throws Exception {
        Integer pid = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api3/product/deleteProduct/{pid}", pid))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Integer pid = 1;
        Product existingProduct = new Product();
        Product updatedProduct = new Product();
        updatedProduct.setName("Updated Name");
        updatedProduct.setStock(10);
        updatedProduct.setPrice(99);

        // Mock the behavior of the repository
        Mockito.when(productRepo.findById(pid)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepo.save(existingProduct)).thenReturn(existingProduct);

        mockMvc.perform(MockMvcRequestBuilders.put("/api3/product/updateProduct/{pid}", pid)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedProduct)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    
    
}



