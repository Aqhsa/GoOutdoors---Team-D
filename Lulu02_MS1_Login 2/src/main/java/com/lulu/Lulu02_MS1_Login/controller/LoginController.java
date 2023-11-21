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

import com.lulu.Lulu02_MS1_Login.entity.Login;
import com.lulu.Lulu02_MS1_Login.entity.SignUp;
import com.lulu.Lulu02_MS1_Login.repository.LoginRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api1/login")
public class LoginController {
	@Autowired
	LoginRepo loginrepo;
	
	@GetMapping("/getLogin")
	public List<Login> getJPQL(){
		return loginrepo.findAll();
	}
	
	@GetMapping("/valid/{email}/{password}")
	public List<Login> getJPQL2(@PathVariable("email") String email ,@PathVariable("password") String password) {
		List<Login> rec=	loginrepo.findAll();  
		for(Login l: rec) {
			System.out.println(l);
 
			if(l.getEmail().equals(email) && l.getPassword().equals(password)  ) {
				System.out.println(" Valid- Authenticated");
				break;
			}else {
				System.out.println("Not Valid");
			}
 
		}	
		return loginrepo.findAll();
	}
	
	@PostMapping("/addLogin")
	public Login createuser(@Valid @RequestBody Login prod) {
		return loginrepo.save(prod);
		}
	
	@DeleteMapping("/deleteLogin/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId  ) {
		loginrepo.deleteById(userId);
		}
	@PutMapping("/updateUser/{userId}")
	public Login updateUser (@PathVariable ("userId") Integer userId, @RequestBody SignUp userBody) {
		 
		Login newUser = loginrepo.findById(userId) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + userId));
		newUser.setUserId(userBody.getUserId()); //the new data replaces the old data.
		return loginrepo.save(newUser);
	}

}
