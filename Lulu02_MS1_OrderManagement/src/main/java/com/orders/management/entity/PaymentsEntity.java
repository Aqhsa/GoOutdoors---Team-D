package com.orders.management.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paymentsEntity")

public class PaymentsEntity {

	
	@Id
	int invoiceNo;
	String paymentDate;
	String paymentStatus;
	
	
		public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
		@Override
	public int hashCode() {
		return Objects.hash(invoiceNo, paymentDate, paymentStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentsEntity other = (PaymentsEntity) obj;
		return invoiceNo == other.invoiceNo && paymentDate == other.paymentDate
				&& Objects.equals(paymentStatus, other.paymentStatus);
	}
		@Override
	public String toString() {
		return "PaymentsEntity [invoiceNo=" + invoiceNo + ", paymentDate=" + paymentDate + ", paymentStatus="
				+ paymentStatus + "]";
	}
		public PaymentsEntity(int invoiceNo, String paymentDate, String paymentStatus) {
		super();
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}
		public PaymentsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
