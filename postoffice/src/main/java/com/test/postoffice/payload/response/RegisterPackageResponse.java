package com.test.postoffice.payload.response;

import java.util.Date;

import com.test.postoffice.entity.EStatus;

public class RegisterPackageResponse {
	
	private int packageId;
	
	private int dstPostOfficeIndex;
	
	private int srcPostOfficeId;
	
	private EStatus status;
	
	private Date date;
	
	private String recipientName;
	
	private String recipientAddress;



	

	public RegisterPackageResponse(int packageId, int dstPostOfficeIndex, int srcPostOfficeId, EStatus status,
			Date date, String recipientName, String recipientAddress) {
		this.packageId = packageId;
		this.dstPostOfficeIndex = dstPostOfficeIndex;
		this.srcPostOfficeId = srcPostOfficeId;
		this.status = status;
		this.date = date;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getDstPostOfficeIndex() {
		return dstPostOfficeIndex;
	}

	public void setDstPostOfficeIndex(int dstPostOfficeIndex) {
		this.dstPostOfficeIndex = dstPostOfficeIndex;
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

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	
	

	public int getSrcPostOfficeId() {
		return srcPostOfficeId;
	}

	public void setSrcPostOfficeId(int srcPostOfficeId) {
		this.srcPostOfficeId = srcPostOfficeId;
	}

	@Override
	public String toString() {
		return "RegisterPackageResponse [packageId=" + packageId + ", dstPostOfficeIndex=" + dstPostOfficeIndex
				+ ", srcPostOfficeId=" + srcPostOfficeId + ", status=" + status + ", date=" + date + ", recipientName="
				+ recipientName + ", recipientAddress=" + recipientAddress + "]";
	}
}
