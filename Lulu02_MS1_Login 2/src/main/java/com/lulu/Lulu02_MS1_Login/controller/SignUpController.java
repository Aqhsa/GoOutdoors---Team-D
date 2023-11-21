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

import com.lulu.Lulu02_MS1_Login.entity.SignUp;
import com.lulu.Lulu02_MS1_Login.repository.SignUpRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api1/signup")
public class SignUpController {
	@Autowired
	SignUpRepo signuprepo;
	
	@GetMapping("/getUser")
	public List<SignUp> getJPQL(){
		return signuprepo.findAll();
	}
	
	@PostMapping("/addUser")
	public SignUp createuser(@Valid @RequestBody SignUp prod) {
		return signuprepo.save(prod);
		}
	
	@PostMapping("/exceptionUser")
	public String createUser2(@Valid @RequestBody SignUp user) {
		SignUp existingUser = null;
		existingUser = signuprepo.findByNameLike(user.getEmail());	
		if (existingUser == null) {
			signuprepo.save(user);
			return "User added successfully";
		}
		else
		{
			return "User already exists!";
		}
 
		
	}
	
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId  ) {
		signuprepo.deleteById(userId);
		}
	
	@PutMapping("/updateUser/{userId}")
	public SignUp updateUser (@PathVariable ("userId") Integer userId, @RequestBody SignUp userBody) {
		 
		SignUp newUser = signuprepo.findById(userId) //old data
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + userId));
		newUser.setUserId(userBody.getUserId()); //the new data replaces the old data.
		newUser.setName(userBody.getName());
		return signuprepo.save(newUser);
	}

}
