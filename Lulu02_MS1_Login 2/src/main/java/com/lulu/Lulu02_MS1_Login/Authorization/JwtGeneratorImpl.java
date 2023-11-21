package com.lulu.Lulu02_MS1_Login.Authorization;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lulu.Lulu02_MS1_Login.entity.Login;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
@Service
public class JwtGeneratorImpl implements JwtGenerator{
  @Value("${jwt.secret}")
  private String secret;
  @Value("${app.jwttoken.message}")
  private String message;
  @Override
  public Map<String, String> generateToken(Login user) {
    String jwtToken="";
    jwtToken = Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
    Map<String, String> jwtTokenGen = new HashMap<>();
    jwtTokenGen.put("token", jwtToken);
    jwtTokenGen.put("message", message);
    return jwtTokenGen;
  }
}