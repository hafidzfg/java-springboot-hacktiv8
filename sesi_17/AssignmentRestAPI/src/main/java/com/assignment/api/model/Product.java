package com.assignment.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "products")
public class Product {
	private int id;
	private String nama;
	private float hargaBeli;
	private float hargaJual;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
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
