package com.test.postoffice.payload.request;

import javax.validation.constraints.Positive;

public class ReceivePackageRequest {
	
	@Positive
	private int packageId;

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	@Override
	public String toString() {
		return "ReceivePackageRequest [packageId=" + packageId + "]";
	}
}
