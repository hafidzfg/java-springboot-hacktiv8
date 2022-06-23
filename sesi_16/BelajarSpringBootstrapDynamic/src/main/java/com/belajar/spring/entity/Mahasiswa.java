package com.belajar.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Mahasiswa {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(length = 64)
	private String id;
	
	@NonNull
	@NotBlank
	@Column(name = "nim", unique = true)
	private String nim;
	
	@NonNull
	@NotBlank
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "ipk")
	private float ipk;
	
	@NonNull
	@NotBlank
	@Column(name = "jurusan")
	private String jurusan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public float getIpk() {
		return ipk;
	}

	public void setIpk(float ipk) {
		this.ipk = ipk;
	}

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}

}
