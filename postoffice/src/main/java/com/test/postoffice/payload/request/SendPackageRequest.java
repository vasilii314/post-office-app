package com.test.postoffice.payload.request;

import javax.validation.constraints.Positive;

public class SendPackageRequest {
	
	@Positive
	private int packageId;
	
	@Positive
	private int postOfficeId;

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getPostOfficeId() {
		return postOfficeId;
	}

	public void setPostOfficeId(int postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	@Override
	public String toString() {
		return "SendPackageRequest [packageId=" + packageId + ", postOfficeId=" + postOfficeId + "]";
	}
}
