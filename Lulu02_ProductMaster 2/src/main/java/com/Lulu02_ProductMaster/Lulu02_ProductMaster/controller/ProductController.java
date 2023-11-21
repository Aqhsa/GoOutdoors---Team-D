package com.Lulu02_ProductMaster.Lulu02_ProductMaster.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Inventory;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Product;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.repo.ProductRepo;
 

@RestController
@RequestMapping("api3/product")
public class ProductController {
	
@Autowired
ProductRepo repo;

@GetMapping("/getProduct")
public List<Product> getJPQL()
{
	return repo.findAll();
}
 
@PostMapping("/addProduct")
public Product createproduct(@RequestBody Product prod) {
	return repo.save(prod);
 
 
}
@DeleteMapping("deleteProduct/{pid}")
 
 
public void delete(@PathVariable ("pid") Integer pid) {
 
	repo.deleteById(pid);
 
}
 
 

 
 @PutMapping("updateProduct/{pid}")
	public Product updateProduct (@PathVariable ("pid") Integer pid, @RequestBody Product product) { //userbody - information comes from postman.
		
		
		
	 Product newUser = repo.findById(pid) //old data
				.orElseThrow(() -> new RuntimeException("Product not exist with id :" + pid));
	 
	 newUser.setName(product.getName()); 
		newUser.setStock(product.getStock()); 
		newUser.setPrice(product.getPrice());
		
		return repo.save(newUser);
	}
 
}
 



