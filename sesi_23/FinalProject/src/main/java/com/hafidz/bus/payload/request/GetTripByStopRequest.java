package com.hafidz.bus.payload.request;

import java.util.Objects;

public class GetTripByStopRequest {
	private Long sourceStopid;

	private Long destStopId;

	@Override
	public int hashCode() {
		return Objects.hash(destStopId, sourceStopid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetTripByStopRequest other = (GetTripByStopRequest) obj;
		return Objects.equals(destStopId, other.destStopId) && Objects.equals(sourceStopid, other.sourceStopid);
	}

	@Override
	public String toString() {
		return "GetTripByStopRequest [sourceStopid=" + sourceStopid + ", destStopId=" + destStopId + ", hashCode()="
				+ hashCode() + ", getSourceStopid()=" + getSourceStopid() + ", getDestStopId()=" + getDestStopId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public GetTripByStopRequest(Long sourceStopid, Long destStopId) {
		super();
		this.sourceStopid = sourceStopid;
		this.destStopId = destStopId;
	}

	public GetTripByStopRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSourceStopid() {
		return sourceStopid;
	}

	public void setSourceStopid(Long sourceStopid) {
		this.sourceStopid = sourceStopid;
	}

	public Long getDestStopId() {
		return destStopId;
	}

	public void setDestStopId(Long destStopId) {
		this.destStopId = destStopId;
	}

}
