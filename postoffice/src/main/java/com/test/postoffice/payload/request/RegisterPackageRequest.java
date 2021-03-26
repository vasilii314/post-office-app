package com.test.postoffice.payload.request;

import javax.validation.constraints.NotNull;

import com.test.postoffice.entity.PostPackage;

public class RegisterPackageRequest {
	
	@NotNull
	private PostPackage pkg;

	public PostPackage getPkg() {
		return pkg;
	}

	public void setPkg(PostPackage pkg) {
		this.pkg = pkg;
	}
	
	@Override
	public String toString() {
		return "RegisterPackageRequest [pkg=" + pkg + "]";
	}
}







