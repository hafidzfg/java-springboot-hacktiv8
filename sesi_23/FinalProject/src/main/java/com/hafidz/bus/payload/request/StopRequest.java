package com.hafidz.bus.payload.request;

import io.swagger.annotations.ApiModelProperty;

public class StopRequest {
	@ApiModelProperty(hidden = true)
	private Long id;

	private String code;

	private String name;

	private String detail;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "StopRequest [id=" + id + ", code=" + code + ", name=" + name + ", detail=" + detail + ", getId()="
				+ getId() + ", getCode()=" + getCode() + ", getName()=" + getName() + ", getDetail()=" + getDetail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public StopRequest(Long id, String code, String name, String detail) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.detail = detail;
	}

	public StopRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
