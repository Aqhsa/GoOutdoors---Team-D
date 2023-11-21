package com.orders.management.controller;

	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.management.entity.OrdersEntity;
import com.orders.management.repository.OrdersRepo;



	@RestController  //We use it to create REST API end point along with http methods like GET,POST,DELETE,PUT,PATCH
	 @RequestMapping("/api2/order")
	public class OrdersController {

			@Autowired
			OrdersRepo orepo;

			@GetMapping("/getOrder")
			public List<OrdersEntity> getJPQL() {
				return orepo.findAll(); // select * from <TableName>;
			}

			@PostMapping("/addOrder")
			public OrdersEntity createuser(@RequestBody OrdersEntity prod) {
				return orepo.save(prod);
			}
			
			@DeleteMapping("/deleteOrder/{id}")
			public void delete(@PathVariable int id) {
				orepo.deleteById(id); // select * from <TableName>;
			}
			
			@PutMapping("/updateOrder/{id}")
			 
			public OrdersEntity update(@PathVariable ("id") Integer orderid, @RequestBody OrdersEntity productBody) { //userbody - information comes from postman.
		 
				OrdersEntity newProduct = orepo.findById(orderid) //old data
		 
						.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + orderid));
		 
				newProduct.setOrderid(productBody.getOrderid()); //the new data replaces the old data.
		 
				newProduct.setDate(productBody.getDate());
		 
		 
				return orepo.save(newProduct);
		 
			
	}
	}

