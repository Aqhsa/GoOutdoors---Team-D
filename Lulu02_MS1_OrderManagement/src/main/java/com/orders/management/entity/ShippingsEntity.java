package com.orders.management.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="shippingentity")

public class ShippingsEntity {


		public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getS_address() {
		return S_address;
	}
	public void setS_address(String s_address) {
		S_address = s_address;
	}
	public String getS_status() {
		return S_status;
	}
	public void setS_status(String s_status) {
		S_status = s_status;
	}
		@Override
	public int hashCode() {
		return Objects.hash(S_address, S_status, Sid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShippingsEntity other = (ShippingsEntity) obj;
		return Objects.equals(S_address, other.S_address) && Objects.equals(S_status, other.S_status)
				&& Sid == other.Sid;
	}
		@Override
	public String toString() {
		return "ShippingsEntity [Sid=" + Sid + ", S_address=" + S_address + ", S_status=" + S_status + "]";
	}
		public ShippingsEntity(int sid, String s_address, String s_status) {
		super();
		Sid = sid;
		S_address = s_address;
		S_status = s_status;
	}
		public ShippingsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Id
		int Sid;
		String S_address;
		String S_status;
		
}
