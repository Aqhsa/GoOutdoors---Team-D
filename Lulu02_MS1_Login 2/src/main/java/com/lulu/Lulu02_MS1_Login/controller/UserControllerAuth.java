package com.lulu.Lulu02_MS1_Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.Lulu02_MS1_Login.Authorization.JwtGenerator;
import com.lulu.Lulu02_MS1_Login.Exception.UserNotFoundException;
import com.lulu.Lulu02_MS1_Login.Service.UserService;
import com.lulu.Lulu02_MS1_Login.entity.Login;

@RestController
@RequestMapping("/api1/v1/user")
public class UserControllerAuth {
	private UserService userService;
	private JwtGenerator jwtGenerator;
	  @Autowired
	  public UserControllerAuth(UserService userService, JwtGenerator jwtGenerator){
	    this.userService=userService;
	    this.jwtGenerator=jwtGenerator;
	  }
	  @PostMapping("/register")
	  public ResponseEntity<?> postUser(@RequestBody Login user){
	  try{
	     userService.saveUser(user);
	     return new ResponseEntity<>(user, HttpStatus.CREATED);
	   } catch (Exception e){
	     return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	   }
	  }
	  @PostMapping("/login")
	  public ResponseEntity<?> loginUser(@RequestBody Login user) {
	    try {
	      if(user.getEmail() == null || user.getPassword() == null) {
	      throw new UserNotFoundException("Email or Password is Empty");
	    }
	    Login userData = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
	    if(userData == null){
	       throw new UserNotFoundException("Email or Password is Invalid");
	    }
	       return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
	    } catch (UserNotFoundException e) {
	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	    }
	  }

}
