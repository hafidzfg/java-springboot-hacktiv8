package com.hafidz.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private ERole name;


	public Role(int id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Role() {

	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", hashCode()=" + hashCode() + ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
