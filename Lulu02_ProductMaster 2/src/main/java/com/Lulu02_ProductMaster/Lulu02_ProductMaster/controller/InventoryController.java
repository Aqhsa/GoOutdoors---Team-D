package com.Lulu02_ProductMaster.Lulu02_ProductMaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity.Inventory;
import com.Lulu02_ProductMaster.Lulu02_ProductMaster.repo.InventoryRepo;
 

@RestController
@RequestMapping("api3/inventory")
public class InventoryController {
	
@Autowired
InventoryRepo repo;

@GetMapping("/getInventory")
public List<Inventory> getJPQL()
{
	return repo.findAll();
}
 
@PostMapping("addInventory")
public Inventory createinventory(@RequestBody Inventory inv) {
	return repo.save(inv);
}

@DeleteMapping("deleteInventory/{id}")
 
 
public void delete(@PathVariable ("id") Integer id) {
 
	repo.deleteById(id);
 
}
 
 
@PutMapping("updateInventory/{id}")
	public Inventory updateInventory (@PathVariable ("id") Integer id, @RequestBody Inventory inventory) { //userbody - information comes from postman.
		
		
		Inventory newUser = repo.findById(id) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		newUser.setStock(inventory.getStock()); 
		newUser.setUnits(inventory.getUnits());
		
		return repo.save(newUser);
	}

}
 


