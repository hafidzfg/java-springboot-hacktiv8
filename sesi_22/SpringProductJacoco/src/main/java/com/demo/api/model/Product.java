package com.demo.api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "products")
public class Product {
	private long id;
	private String name;
	private float hargaBeli;
	private float hargaJual;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHargaBeli() {
		return hargaBeli;
	}
	public void setHargaBeli(float hargaBeli) {
		this.hargaBeli = hargaBeli;
	}
	public float getHargaJual() {
		return hargaJual;
	}
	public void setHargaJual(float hargaJual) {
		this.hargaJual = hargaJual;
	}
	
	

}
