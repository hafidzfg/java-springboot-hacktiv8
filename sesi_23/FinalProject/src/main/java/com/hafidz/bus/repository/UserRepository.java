package com.hafidz.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafidz.bus.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	User getByUsername(String username);
	
	User findUserById(Long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
