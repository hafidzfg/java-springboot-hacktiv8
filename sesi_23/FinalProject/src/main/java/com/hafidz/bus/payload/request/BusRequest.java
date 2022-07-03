package com.hafidz.bus.payload.request;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class BusRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private String code;
	
	private int capacity;
	
	private String make;
	
	@ApiModelProperty(hidden = true)
	private long agencyId;

	@Override
	public int hashCode() {
		return Objects.hash(agencyId, capacity, code, id, make);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusRequest other = (BusRequest) obj;
		return agencyId == other.agencyId && capacity == other.capacity && Objects.equals(code, other.code)
				&& Objects.equals(id, other.id) && Objects.equals(make, other.make);
	}

	@Override
	public String toString() {
		return "BusRequest [id=" + id + ", code=" + code + ", capacity=" + capacity + ", make=" + make + ", agencyId="
				+ agencyId + ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getCode()=" + getCode()
				+ ", getCapacity()=" + getCapacity() + ", getMake()=" + getUsedCapacity() + ", getAgencyId()=" + getAgencyId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public BusRequest(Long id, String code, int capacity, String make, long agencyId) {
		super();
		this.id = id;
		this.code = code;
		this.capacity = capacity;
		this.make = make;
		this.agencyId = agencyId;
	}

	public BusRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getUsedCapacity() {
		return make;
	}

	public void setUsedCapacity(String make) {
		this.make = make;
	}

	public long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}
	
	
}
