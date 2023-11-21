package com.Lulu02_ProductMaster.Lulu02_ProductMaster.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
 
 
 
@Entity
@Table(name="inventory")
 
public class Inventory{
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int id;
	String stock;
    int units;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", stock=" + stock + ", units=" + units + "]";
	}
	public Inventory(int id, String stock, int units) {
		super();
		this.id = id;
		this.stock = stock;
		this.units = units;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}