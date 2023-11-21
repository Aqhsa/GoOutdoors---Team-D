package com.lulu.Lulu02_MS1_Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.Lulu02_MS1_Login.entity.Login;

public interface LoginRepo extends JpaRepository<Login,Integer > {
	@Query(value = "SELECT * FROM login WHERE email  LIKE(:letter)", nativeQuery = true)
	Login findByNameLike(@Param("letter") String letter);
	
	public Login findByEmailAndPassword(String email, String password);
}
