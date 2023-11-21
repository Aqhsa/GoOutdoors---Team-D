package com.lulu.Lulu02_MS1_Login.Exception;

public class UserAlreadyExists extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
 
	public UserAlreadyExists() {
 
	}
 
	public UserAlreadyExists(String msg) {
 
		super(msg);
 
		this.message = msg;
 
	}
 
}