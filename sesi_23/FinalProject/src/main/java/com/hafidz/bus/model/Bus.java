package com.hafidz.bus.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private int capacity;
	
	private String availableCapacity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id")
	private Agency agency;
	
	@Override
	public int hashCode() {
		return Objects.hash(agency, capacity, code, id, availableCapacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(agency, other.agency) && capacity == other.capacity && Objects.equals(code, other.code)
				&& Objects.equals(id, other.id) && Objects.equals(availableCapacity, other.availableCapacity);
	}

	public Bus(Long id, String code, int capacity, String usedCapacity, Agency agency) {
		super();
		this.id = id;
		this.code = code;
		this.capacity = capacity;
		this.availableCapacity = usedCapacity;
		this.agency = agency;
	}

	public Bus() {

	}

	public Bus(String code, int capacity, String make, Agency agency) {
		this.code= code;
		this.capacity = capacity;
		this.availableCapacity = make;
		this.agency = agency;
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

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	public String getUsedCapacity() {
		return availableCapacity;
	}

	public void setUsedCapacity(String usedCapacity) {
		this.availableCapacity = usedCapacity;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", code=" + code + ", capacity=" + capacity + ", availableCapacity=" + availableCapacity
				+ ", agency=" + agency + ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getCode()="
				+ getCode() + ", getCapacity()=" + getCapacity() + ", getAgency()=" + getAgency()
				+ ", getUsedCapacity()=" + getUsedCapacity() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
