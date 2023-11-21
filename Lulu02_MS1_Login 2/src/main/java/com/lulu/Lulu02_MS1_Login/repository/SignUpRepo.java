package com.lulu.Lulu02_MS1_Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.Lulu02_MS1_Login.entity.SignUp;


public interface SignUpRepo extends JpaRepository<SignUp,Integer > {
	@Query(value = "SELECT * FROM signup WHERE email  LIKE(:letter)", nativeQuery = true)
		SignUp findByNameLike(@Param("letter") String letter);

}
