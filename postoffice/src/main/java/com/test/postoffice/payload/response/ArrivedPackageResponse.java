package com.test.postoffice.payload.response;

import java.util.Date;

import com.test.postoffice.entity.EStatus;

public class ArrivedPackageResponse {
	
	private int pkgId;
	
	private EStatus status;
	
	private Date date;
	
	private int postalIndex;

	public ArrivedPackageResponse(int pkgId, EStatus status, Date date, int postalIndex) {
		this.pkgId = pkgId;
		this.status = status;
		this.date = date;
		this.postalIndex = postalIndex;
	}

	public int getPkgId() {
		return pkgId;
	}

	public void setPkgId(int pkgId) {
		this.pkgId = pkgId;
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

	public int getPostalIndex() {
		return postalIndex;
	}

	public void setPostalIndex(int postalIndex) {
		this.postalIndex = postalIndex;
	}

	@Override
	public String toString() {
		return "ArrivedPackageResponse [pkgId=" + pkgId + ", status=" + status + ", date=" + date + ", postalIndex="
				+ postalIndex + "]";
	}
}
