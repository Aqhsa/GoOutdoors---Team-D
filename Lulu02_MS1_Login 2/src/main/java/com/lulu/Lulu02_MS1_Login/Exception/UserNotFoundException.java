package com.lulu.Lulu02_MS1_Login.Exception;

public class UserNotFoundException extends RuntimeException {
	 
    public UserNotFoundException() {
        super();
    }
 
    public UserNotFoundException(String message) {
        super(message);
    }
 
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
