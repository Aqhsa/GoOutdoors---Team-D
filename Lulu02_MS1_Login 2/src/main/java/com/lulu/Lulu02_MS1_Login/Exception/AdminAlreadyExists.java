package com.lulu.Lulu02_MS1_Login.Exception;

public class AdminAlreadyExists extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
 
	public AdminAlreadyExists() {
 
	}
 
	public AdminAlreadyExists(String msg) {
 
		super(msg);
 
		this.message = msg;
 
	}
 
}

