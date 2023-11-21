package com.Lulu02.Lulu02_Promotions.entity;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
 
 
 
@Entity
@Table(name="promotion")
 
public class Promotion{
	
	@Id
	//@GeneratedValue(strategy =GenerationType.AUTO)
	
	
	int promoid;
	String expiry ;
	String code;
	float percent;
	public int getPromoid() {
		return promoid;
	}
	public void setPromoid(int promoid) {
		this.promoid = promoid;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String newInfo) {
		this.code = newInfo;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, expiry, percent, promoid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		return Objects.equals(code, other.code) && Objects.equals(expiry, other.expiry)
				&& Float.floatToIntBits(percent) == Float.floatToIntBits(other.percent) && promoid == other.promoid;
	}
	@Override
	public String toString() {
		return "Promotion [promoid=" + promoid + ", expiry=" + expiry + ", code=" + code + ", percent=" + percent + "]";
	}
	public Promotion(int promoid, String expiry, String code, float percent) {
		super();
		this.promoid = promoid;
		this.expiry = expiry;
		this.code = code;
		this.percent = percent;
	}
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

