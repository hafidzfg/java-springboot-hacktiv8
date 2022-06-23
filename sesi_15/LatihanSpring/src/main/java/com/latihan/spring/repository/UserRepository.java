package com.latihan.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.latihan.spring.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
