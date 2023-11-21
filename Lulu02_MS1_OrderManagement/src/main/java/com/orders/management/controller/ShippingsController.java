package com.orders.management.controller;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.management.entity.ShippingsEntity;
import com.orders.management.repository.ShippingsRepo; 

	@RequestMapping("api2/shipping")
	@RestController
	public class ShippingsController {

		@Autowired
		ShippingsRepo srepo;

		@GetMapping("/getShipping")
		public List<ShippingsEntity> getProducts() {

	 
			return srepo.findAll(); // select * from <TableName>;
	
		}

		@PostMapping("/addShipping")
		public ShippingsEntity createuser(@RequestBody ShippingsEntity prod) {
			return srepo.save(prod);
		}

		@DeleteMapping("/deleteShipping/{Sid}")
		public void deletProduct(@PathVariable("Sid") Integer Sid  ) {

			srepo.deleteById(Sid); // select * from <TableName>;

		}
	}


