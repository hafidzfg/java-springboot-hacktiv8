package com.hafidz.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hafidz.bus.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "SELECT COUNT(*) FROM trip_schedule ts JOIN ticket t ON ts.id = t.trip_schedule_id "
			+ "JOIN user ON t.passenger_id = user.id WHERE user.id = :userId "
			+ "AND ts.id = :tripScheduleId", nativeQuery = true)
	int getBookedSeatsByPassengerId(Long userId, Long tripScheduleId);

}
