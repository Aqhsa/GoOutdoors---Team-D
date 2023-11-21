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

import com.orders.management.entity.PaymentsEntity;
import com.orders.management.repository.PaymentsRepo;

	@RestController
	@RequestMapping("/api2/payment")
	public class PaymentsController {

		@Autowired
		PaymentsRepo prepo;

		@GetMapping("/getPayments")
		public List<PaymentsEntity> getProducts() {

			return prepo.findAll(); // select * from <TableName>;

		}


		@PostMapping("/addPayments")
		public PaymentsEntity createPayments(@RequestBody PaymentsEntity prod) {
			
			//might have to add @valid after requestbody to trigger exception in @size(cCustomercare.java)
			return prepo.save(prod);
		}

		@DeleteMapping("/delete/{invoiceNo}")
		public void deletProduct(@PathVariable("invoiceNo") Integer invoiceNo  ) {


			prepo.deleteById(invoiceNo); // select * from <TableName>;
		}	
	}
