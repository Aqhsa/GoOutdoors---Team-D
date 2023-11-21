package com.lulu.Lulu02_MS1_Login.entity;


//import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="login")
public class Login {
	@Id
	private int userId;
	private String email;
	@Size(min = 8, max = 14, message = "Password does not match")
	private String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int userId, @Size(min = 8, max = 14, message = "Password does not match") String email,
			String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	@Override
//	public String toString() {
//		return "Login [userId=" + userId + ", email=" + email + ", password=" + password + "]";
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(email, password, userId);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Login other = (Login) obj;
//		return Objects.equals(email, other.email) && Objects.equals(password, other.password) && userId == other.userId;
//	}
	
	
	
	
	

}
