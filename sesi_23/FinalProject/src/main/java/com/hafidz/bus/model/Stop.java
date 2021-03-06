package com.hafidz.bus.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stop")
public class Stop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private String name;
	
	private String detail;
	
	@Override
	public int hashCode() {
		return Objects.hash(code, detail, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stop other = (Stop) obj;
		return Objects.equals(code, other.code) && Objects.equals(detail, other.detail) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", code=" + code + ", name=" + name + ", detail=" + detail + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getCode()=" + getCode() + ", getName()=" + getName()
				+ ", getDetail()=" + getDetail() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	public Stop(String code, String name, String detail) {
		super();
		this.code = code;
		this.name = name;
		this.detail = detail;
	}

	public Stop() {
		
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
