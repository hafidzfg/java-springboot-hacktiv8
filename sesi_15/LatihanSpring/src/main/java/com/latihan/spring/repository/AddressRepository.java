package com.latihan.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.latihan.spring.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
