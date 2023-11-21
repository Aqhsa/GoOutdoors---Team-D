package com.lulu.Lulu02_MS1_ReturnsManagement.controller;

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
import com.lulu.Lulu02_MS1_ReturnsManagement.entity.Returns;
import com.lulu.Lulu02_MS1_ReturnsManagement.repository.ReturnsRepo;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/return")
public class ReturnsController {
	@Autowired
	ReturnsRepo rrepo;
	
	@GetMapping("/getReturns")
	public List<Returns> getJPQL(){
		return rrepo.findAll();
	}
	
	@PostMapping("/addReturns")
	public Returns createuser(@Valid @RequestBody Returns prod) {
	return rrepo.save(prod);
	}
	
	@DeleteMapping("/deleteReturn/{rid}")
	public void deleteUser(@PathVariable("rid") Integer rid  ) {
		rrepo.deleteById(rid);
		}
	
	@PutMapping("/updateReturn/{rid}")
	public Returns updateReturn (@PathVariable ("rid") Integer id, @RequestBody Returns userBody) {
 
		Returns newReturn = rrepo.findById(id) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newReturn.setRid(userBody.getRid()); //the new data replaces the old data.
		newReturn.setReason(userBody.getReason());
		return rrepo.save(newReturn);
	}

}
