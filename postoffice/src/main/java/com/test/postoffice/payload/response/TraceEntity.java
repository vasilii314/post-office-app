package com.test.postoffice.payload.response;

import java.util.Date;

import com.test.postoffice.entity.EStatus;

public class TraceEntity {
	
	private String postOfficeAddr;
	private EStatus status;
	private Date date;
	
	public TraceEntity(String postOfficeAddr, EStatus status, Date date) {
		this.postOfficeAddr = postOfficeAddr;
		this.status = status;
		this.date = date;
	}
	
	public String getPostOfficeAddr() {
		return postOfficeAddr;
	}
	
	public void setPostOfficeAddr(String postOfficeAddr) {
		this.postOfficeAddr = postOfficeAddr;
	}
	
	public EStatus getStatus() {
		return status;
	}
	
	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "TraceEntity [postOfficeAddr=" + postOfficeAddr + ", status=" + status + ", date=" + date + "]";
	}
}
