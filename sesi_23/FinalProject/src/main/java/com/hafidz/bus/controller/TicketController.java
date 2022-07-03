package com.hafidz.bus.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafidz.bus.model.Stop;
import com.hafidz.bus.model.Ticket;
import com.hafidz.bus.model.TripSchedule;
import com.hafidz.bus.model.User;
import com.hafidz.bus.payload.request.TicketRequest;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.TicketRepository;
import com.hafidz.bus.repository.TripScheduleRepository;
import com.hafidz.bus.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> getAllTickets() {
		List<TicketRequest> dataArrResult = new ArrayList<>();
		for (Ticket dataArr : ticketRepository.findAll()) {
			dataArrResult.add(new TicketRequest(dataArr.getId(), dataArr.getSeatNumber(), dataArr.isCancellable(), dataArr.getJourneyDate(), dataArr.getUser().getId(), dataArr.getTripSchedule().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<TicketRequest>(true, "Success Retrieving Data", dataArrResult));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTicketById(@PathVariable(value = "id") Long id) {
		Ticket ticket = ticketRepository.findById(id).get();
		if (ticket == null) {
			return ResponseEntity.notFound().build();
		} else {
			TicketRequest dataResult = new TicketRequest(ticket.getId(), ticket.getSeatNumber(), ticket.isCancellable(), ticket.getJourneyDate(), ticket.getUser().getId(), ticket.getTripSchedule().getId());
			return ResponseEntity.ok(new MessageResponse<TicketRequest>(true, "Success Retrieving Data", dataResult));
		}
	}
	
	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTicket(@Valid @RequestBody TicketRequest ticketRequest) {
		User user = userRepository.findById(ticketRequest.getPassengerId()).get();
	    TripSchedule tripSchedule = tripScheduleRepository.findById(ticketRequest.getId()).get();
		Ticket ticket = new Ticket(ticketRequest.getSeatNumber(), ticketRequest.getCancellable(),
				ticketRequest.getJourneyDate(), 
				user, tripSchedule);
		return ResponseEntity.ok(new MessageResponse<Ticket>(true, "Success Adding Ticket", ticketRepository.save(ticket)));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTicket(@Valid @RequestBody TicketRequest ticketRequest) {
		Ticket ticket = ticketRepository.findById(ticketRequest.getId()).get();
		if(ticket == null) {
			return ResponseEntity.notFound().build();
		}
		User user = userRepository.findById(ticketRequest.getPassengerId()).get();
	    TripSchedule tripSchedule = tripScheduleRepository.findById(ticketRequest.getId()).get();
	    
	    
	    
		ticket.setSeatNumber(ticketRequest.getSeatNumber());
		ticket.setCancellable(ticketRequest.getCancellable());
		ticket.setJourneyDate(ticketRequest.getJourneyDate());
		
		ticket.setUser(user);
		ticket.setTripSchedule(tripSchedule);
		
		Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(new MessageResponse<Ticket>(true, "Updating Ticket done", updatedTicket));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			ticketRepository.findById(id).get();
			
			result = "Ticket with id: " + id + " is deleted";
			ticketRepository.deleteById(id);
			
			return ResponseEntity.ok(new MessageResponse<Stop>(true, result));
		} catch (Exception e) {
			result = "Ticket with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Stop>(false, result));
		}
	}

}
