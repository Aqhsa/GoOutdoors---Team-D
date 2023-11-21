package com.orders.management.entity;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderentity")
public class OrdersEntity{	
	
		@Id
		int orderid;
		String date;
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		@Override
		public int hashCode() {
			return Objects.hash(date, orderid);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrdersEntity other = (OrdersEntity) obj;
			return date == other.date && orderid == other.orderid;
		}
		@Override
		public String toString() {
			return "OrdersEntity [orderid=" + orderid + ", date=" + date + "]";
		}
		public OrdersEntity(int orderid, String date) {
			super();
			this.orderid = orderid;
			this.date = date;
		}
		public OrdersEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

}
