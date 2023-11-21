package com.lulu.Lulu02_MS1_Login.controller;

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

import com.lulu.Lulu02_MS1_Login.entity.Admin;
import com.lulu.Lulu02_MS1_Login.repository.AdminRepo;

import jakarta.validation.Valid;




@RestController 
@RequestMapping("/api1/admin")
public class AdminController {
	@Autowired
	AdminRepo Arepo;
	
	
	@GetMapping("/getAdmin")
	public List<Admin> getJPQL(){
		return Arepo.findAll();
	}
	
	@GetMapping("/valid/{AId}/{Aname}")
	public List<Admin> getJPQL2(@PathVariable("AId") int AId ,@PathVariable("Aname") String Aname) {
		List<Admin> rec=	Arepo.findAll();  
		for(Admin a: rec) {
			System.out.println(a);
 
			if(a.getAId()==AId && a.getAname().equals(Aname)  ) {
				System.out.println(" Valid- Authenticated");
				break;
			}else {
				System.out.println("Not Valid");
			}
 
		}	
		return Arepo.findAll();
	}
	
@PostMapping("/exceptionAdmin")
	public String createAdmin2(@Valid @RequestBody Admin admin) {
		Admin existingAdmin;
		existingAdmin = Arepo.findByIdLike(admin.getAId());	
		if (existingAdmin == null) {
			Arepo.save(admin);
			return "Admin added successfully";
		}
		else
		{
			return "Admin already exist!";
		}
 
		
	}
 
	@PostMapping("/addAdmin")
	public Admin createuser(@Valid @RequestBody Admin prod) {
	return Arepo.save(prod);
	}
	
	
	@DeleteMapping("/Admin/{id}")
	public void deleteUser(@PathVariable("AId") Integer id  ) {
		Arepo.deleteById(id);
		}

 
	@PutMapping("/emp/{id}")
	public Admin updateUser (@PathVariable ("id") Integer id, @RequestBody Admin userBody) {
 
		Admin newAdmin = Arepo.findById(id) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newAdmin.setAId(userBody.getAId()); //the new data replaces the old data.
		newAdmin.setAname(userBody.getAname());
		return Arepo.save(newAdmin);
 
 
 
	}

}

