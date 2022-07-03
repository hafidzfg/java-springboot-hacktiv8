package com.hafidz.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hafidz.bus.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long>{
	@Query(value = "SELECT * FROM bus WHERE agency_id = :id", nativeQuery = true)
    List<Bus> findByAgencyId(Long id);
}
