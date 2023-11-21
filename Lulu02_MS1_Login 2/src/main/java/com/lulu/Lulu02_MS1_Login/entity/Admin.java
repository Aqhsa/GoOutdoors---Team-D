package com.lulu.Lulu02_MS1_Login.entity;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	int AId;
	@Size(min = 8, max = 30, message = "Name must be at least 8 characters long and less than 30 characters")
	String Aname;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int aId, String aname) {
		super();
		AId = aId;
		Aname = aname;
	}
	public int getAId() {
		return AId;
	}
	public void setAId(int aId) {
		AId = aId;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	@Override
	public String toString() {
		return "Admin [AId=" + AId + ", Aname=" + Aname + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(AId, Aname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return AId == other.AId && Objects.equals(Aname, other.Aname);
	}
	
	

}
