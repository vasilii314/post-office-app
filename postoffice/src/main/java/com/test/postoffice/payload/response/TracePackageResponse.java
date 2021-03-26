package com.test.postoffice.payload.response;

import java.util.List;

public class TracePackageResponse {
	
	private int pkgId;

	private List<TraceEntity> history;

	public TracePackageResponse(int pkgId, List<TraceEntity> history) {
		this.pkgId = pkgId;
		this.history = history;
	}

	@Override
	public String toString() {
		return "TracePackageResponse [pkgId=" + pkgId + ", history=" + history + "]";
	}

	public int getPkgId() {
		return pkgId;
	}

	public void setPkgId(int pkgId) {
		this.pkgId = pkgId;
	}

	public List<TraceEntity> getHistory() {
		return history;
	}

	public void setHistory(List<TraceEntity> history) {
		this.history = history;
	}
}
