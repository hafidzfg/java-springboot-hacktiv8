package com.hafidz.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafidz.bus.model.ERole;
import com.hafidz.bus.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}
