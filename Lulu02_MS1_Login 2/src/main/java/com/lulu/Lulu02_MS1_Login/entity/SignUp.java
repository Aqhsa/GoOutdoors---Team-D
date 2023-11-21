package com.lulu.Lulu02_MS1_Login.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Signup")
public class SignUp {
	@Id
	int userId;
	@Size(min = 8, max = 14, message = "Password must be at least 8 characters long and less than 30 characters")
	String password;
	int phone;
	String name;
	String email;
	String country;
	String area;
	int pincode;
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUp(int userId, String password, int phone, String name, String email, String country, String area,
			int pincode) {
		super();
		this.userId = userId;
		this.password = password;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.country = country;
		this.area = area;
		this.pincode = pincode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "SignUp [userId=" + userId + ", password=" + password + ", phone=" + phone + ", name=" + name
				+ ", email=" + email + ", country=" + country + ", area=" + area + ", pincode=" + pincode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area, country, email, name, password, phone, pincode, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUp other = (SignUp) obj;
		return Objects.equals(area, other.area) && Objects.equals(country, other.country)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && phone == other.phone && pincode == other.pincode
				&& userId == other.userId;
	}
	
	
	
	

}
