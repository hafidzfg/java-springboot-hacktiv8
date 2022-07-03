package com.hafidz.bus.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agency")
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private String name;

	private String details;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_user_id")
	private User owner;

	@OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
	private Set<Bus> buses;


	public Agency(String code, String details, String name, User owner) {
		super();
		this.code = code;
		this.name = name;
		this.details = details;
		this.owner = owner;
	}

	/**
	 * @return the buses
	 */
	public Set<Bus> getBuses() {
		return buses;
	}

	/**
	 * @param buses the buses to set
	 */
	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}

	public Agency() {

	}

	public Set<Bus> getBus() {
		return buses;
	}

	public void setBus(Set<Bus> bus) {
		this.buses = bus;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", code=" + code + ", name=" + name + ", details=" + details + ", owner=" + owner
				+ ", bus=" + buses + ", hashCode()=" + hashCode() + ", getBus()=" + getBus() + ", getId()=" + getId()
				+ ", getCode()=" + getCode() + ", getName()=" + getName() + ", getDetails()=" + getDetails()
				+ ", getOwner()=" + getOwner() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

}
