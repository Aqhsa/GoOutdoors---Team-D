package com.Lulu02_ProductMaster.Lulu02_ProductMaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Product;



public interface ProductRepo extends JpaRepository<Product, Integer> { 
}


