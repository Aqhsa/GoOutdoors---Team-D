package com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity;

import java.util.Objects;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
 
 
 
@Entity
@Table(name="product")
 
public class Product{
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int pid;
	String name;
	int price;
	int stock;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	public Product(int pid, String name, int price, int stock) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}