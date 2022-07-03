package com.hafidz.bus.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafidz.bus.model.Ticket;
import com.hafidz.bus.model.Trip;
import com.hafidz.bus.model.TripSchedule;
import com.hafidz.bus.model.User;
import com.hafidz.bus.payload.request.GetTripByStopRequest;
import com.hafidz.bus.payload.request.GetTripScheduleRequest;
import com.hafidz.bus.payload.request.ReservationRequest;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.TicketRepository;
import com.hafidz.bus.repository.TripRepository;
import com.hafidz.bus.repository.TripScheduleRepository;
import com.hafidz.bus.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TripRepository tripRepository;

	@Autowired
	TripScheduleRepository tripScheduleRepository;

	@GetMapping("/tripschedules")
	@ApiOperation(value = "get all trip schedule", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllTripSchedule() {
		List<GetTripScheduleRequest> dataArrResult = new ArrayList<>();
		for (TripSchedule dataArr : tripScheduleRepository.findAll()) {
			dataArrResult.add(new GetTripScheduleRequest(dataArr.getId(), dataArr.getAvailableSeats(), dataArr.getId(),
					dataArr.getTripDate()));
		}
		return ResponseEntity.ok(new MessageResponse<GetTripScheduleRequest>(true, "Success getting trip by schedule", dataArrResult));
	}
	
	@GetMapping("/tripbystops")
	@ApiOperation(value = "get trip by stop", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getTripByStop(@Valid @RequestBody GetTripByStopRequest getTripByStopRequest) {
		Long sourceStop = getTripByStopRequest.getSourceStopid();
		Long destStop = getTripByStopRequest.getDestStopId();

		List<Trip> trip = tripRepository.findTripsByStops(sourceStop, destStop);

		if (trip.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {return ResponseEntity.ok(new MessageResponse<Trip>(true, "Success getting trip by stop", trip));}
		
	}
	
	
	// book a ticket
	@PostMapping("/bookticket")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> bookTicket(@Valid @RequestBody ReservationRequest reservationRequest) {
		int seatNumber = reservationRequest.getSeatNumber();
		Long tripScheduleId = reservationRequest.getTripScheduleId();

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User user = userRepository.getByUsername(username);
		Long passengerId = user.getId();

		// check if ticket is cancellable
		boolean cancellable = reservationRequest.getCancellable();

		// Get trip schedule
		TripSchedule schedule = tripScheduleRepository.findTripScheduleById(tripScheduleId);

		if (schedule.getId() == null) {
			return ResponseEntity.badRequest().build();
		}

		// Get journey date berdasarkan column trip date milik trip schedule
		String journeyDate = schedule.getTripDate();

		// Get passenger
		User passenger = userRepository.findUserById(passengerId);

		// Get LocalDate hari ini
		LocalDate today = LocalDate.now();
		System.out.println("-----TODAY DATE-----: " + today);

		// Parse date
		String tripDateString = tripScheduleRepository.findTripScheduleById(tripScheduleId).getTripDate();
		LocalDate tripDate = LocalDate.parse(tripDateString);

		// check if trip schedule valid
		if (tripDate.isBefore(today)) {
			return ResponseEntity.badRequest().build();
		}

		// check if user exist
		if (passenger.getId() == null) {
			return new ResponseEntity<>("Passenger account not found", HttpStatus.BAD_REQUEST);
		}

		// Check available seats
		int availableSeats = schedule.getAvailableSeats();
		if (availableSeats == 0) {
			return new ResponseEntity<>("No ticket available", HttpStatus.BAD_REQUEST);
		}

		// check if user already booked the seat
		int bookedSeatsByPassenger = ticketRepository.getBookedSeatsByPassengerId(passengerId, tripScheduleId);

		// check if user already has a ticket
		if (bookedSeatsByPassenger > 0) {
			return new ResponseEntity<>("You already have a ticket", HttpStatus.BAD_REQUEST);
		}

		// check bus capacity
		int capacity = schedule.getTrip().getBus().getCapacity();

		// check if seat number valid
		if (seatNumber > capacity) {
			return new ResponseEntity<>("Seat number is not valid", HttpStatus.BAD_REQUEST);
		}

		// get all booked seat number
		List<Integer> numberBooked = tripScheduleRepository.findAllSeatNumberBooked(tripScheduleId);

		// check if seat is already booked
		if (numberBooked.contains(seatNumber)) {
			return new ResponseEntity<>("Seat number already booked, please choose the other seat", HttpStatus.BAD_REQUEST);
		}

		// Create new ticket object
		Ticket ticket = new Ticket(seatNumber, cancellable, journeyDate, passenger, schedule);

		// save ticket to database
		ticketRepository.save(ticket);

		// minus the available seats
		schedule.setAvailableSeats(availableSeats - 1);
		tripScheduleRepository.save(schedule);

		return new ResponseEntity<>("Reservation success!", HttpStatus.OK);
	}

}
