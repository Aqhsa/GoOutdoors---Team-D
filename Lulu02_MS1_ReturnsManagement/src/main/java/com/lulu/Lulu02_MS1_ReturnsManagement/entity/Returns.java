package com.lulu.Lulu02_MS1_ReturnsManagement.entity;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="returns")
public class Returns {
	@Id
	int rid;
	int pid;
	String rdate;
	String reason;
	String refundStatus;
	public Returns() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Returns(int rid, int pid, String rdate, String reason, String refundStatus) {
		super();
		this.rid = rid;
		this.pid = pid;
		this.rdate = rdate;
		this.reason = reason;
		this.refundStatus = refundStatus;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	@Override
	public String toString() {
		return "Returns [rid=" + rid + ", pid=" + pid + ", rdate=" + rdate + ", reason=" + reason + ", refundStatus="
				+ refundStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(pid, rdate, reason, refundStatus, rid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Returns other = (Returns) obj;
		return pid == other.pid && Objects.equals(rdate, other.rdate) && Objects.equals(reason, other.reason)
				&& Objects.equals(refundStatus, other.refundStatus) && rid == other.rid;
	}
	
	

}
