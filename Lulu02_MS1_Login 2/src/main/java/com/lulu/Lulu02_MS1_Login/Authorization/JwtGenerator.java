package com.lulu.Lulu02_MS1_Login.Authorization;

import java.util.Map;

import com.lulu.Lulu02_MS1_Login.entity.Login;


public interface JwtGenerator {
Map<String, String> generateToken(Login user);
}
