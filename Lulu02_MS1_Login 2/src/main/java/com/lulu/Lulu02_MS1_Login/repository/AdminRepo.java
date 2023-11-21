package com.lulu.Lulu02_MS1_Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.Lulu02_MS1_Login.entity.Admin;




public interface AdminRepo extends JpaRepository<Admin,Integer > {
	@Query(value = "SELECT * FROM admin WHERE AId  LIKE(:letter)", nativeQuery = true)
	Admin findByIdLike(@Param("letter") int i);

}
