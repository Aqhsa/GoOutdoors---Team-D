package com.lulu.Lulu02_MS1_Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lulu.Lulu02_MS1_Login.Exception.UserNotFoundException;
import com.lulu.Lulu02_MS1_Login.entity.Login;
import com.lulu.Lulu02_MS1_Login.repository.LoginRepo;
 

@Service
public class UserServiceImpl implements UserService {
  private LoginRepo loginrepo;
  @Autowired
  public UserServiceImpl(LoginRepo loginrepo){
    this.loginrepo=loginrepo;
  }
  @Override
  public void saveUser(Login user) {
    loginrepo.save(user);
  }
  @Override
  public Login getUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
    Login user = loginrepo.findByEmailAndPassword(email, password);
    if(user == null){
       throw new UserNotFoundException("Invalid id and password");
    }
    return user;
  }
}
