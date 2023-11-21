package com.lulu.Lulu02_MS1_Login.Service;

import org.springframework.stereotype.Service;

import com.lulu.Lulu02_MS1_Login.Exception.UserNotFoundException;
import com.lulu.Lulu02_MS1_Login.entity.Login;


@Service
public interface UserService {
    public void saveUser(Login user);
    public Login getUserByEmailAndPassword(String email, String password) throws UserNotFoundException;
}
