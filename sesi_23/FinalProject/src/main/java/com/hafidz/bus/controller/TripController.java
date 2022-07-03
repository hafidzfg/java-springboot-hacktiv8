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

import com.hafidz.bus.model.Agency;
import com.hafidz.bus.model.Bus;
import com.hafidz.bus.model.Stop;
import com.hafidz.bus.model.Trip;
import com.hafidz.bus.payload.request.TripRequest;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.AgencyRepository;
import com.hafidz.bus.repository.BusRepository;
import com.hafidz.bus.repository.StopRepository;
import com.hafidz.bus.repository.TripRepository;
import io.swagger.annotations.Authorization;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/trip")
public class TripController {
	@Autowired
	TripRepository tripRepository;

	@Autowired
	AgencyRepository agencyRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	StopRepository stopRepository;
	
	@GetMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAll() {
		List<TripRequest> dataArrResult = new ArrayList<>();
		for (Trip dataArr : tripRepository.findAll()) {
			dataArrResult.add(new TripRequest(dataArr.getId(), dataArr.getFare(), dataArr.getJourneyTime(),
					dataArr.getSourceStop().getId(), dataArr.getDestStop().getId(), dataArr.getBus().getId(), dataArr.getAgency().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<TripRequest>(true, "Success Retrieving Data", dataArrResult));
	}

	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTrip(@Valid @RequestBody TripRequest tripRequest) {
		Agency agency = agencyRepository.findById(tripRequest.getAgencyId()).get();
		Bus bus = busRepository.findById(tripRequest.getBusId()).get();
		Stop sourceStop = stopRepository.findById(tripRequest.getSourceStopId()).get();
		Stop destStop = stopRepository.findById(tripRequest.getDestStopId()).get();
		Trip trip = new Trip(tripRequest.getFare(), tripRequest.getJourneyTime(), sourceStop, destStop, bus, agency);
		return ResponseEntity.ok(tripRepository.save(trip));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTripByAgencyId(@PathVariable(value = "id") Long id) {
		Trip trip = tripRepository.findById(id).get();
		if (trip == null) {
			return ResponseEntity.notFound().build();
		} else {
			TripRequest dataResult = new TripRequest(trip.getId(), trip.getFare(), trip.getJourneyTime(),
					trip.getSourceStop().getId(), trip.getDestStop().getId(), trip.getBus().getId(), trip.getAgency().getId());
			return ResponseEntity.ok(new MessageResponse<TripRequest>(true, "Success Retrieving Data", dataResult));
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTrip(@PathVariable(value = "id") Long id, @Valid @RequestBody TripRequest tripRequest) {
		Agency agency = agencyRepository.findById(tripRequest.getAgencyId()).get();
		Bus bus = busRepository.findById(tripRequest.getBusId()).get();
		Stop sourceStop = stopRepository.findById(tripRequest.getSourceStopId()).get();
		Stop destStop = stopRepository.findById(tripRequest.getDestStopId()).get();
		Trip trip = tripRepository.findById(id).get();
		if (trip == null) {
			return ResponseEntity.notFound().build();
		}
		
		trip.setFare(tripRequest.getFare());
		trip.setJourneyTime(tripRequest.getJourneyTime());
		trip.setSourceStop(sourceStop);
		trip.setDestStop(destStop);
		trip.setBus(bus);
		trip.setAgency(agency);
		
		Trip updatedTrip = tripRepository.save(trip);
		return ResponseEntity.ok(new MessageResponse<Trip>(true, "Success updating data", updatedTrip));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTrip(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			tripRepository.findById(id).get();
			
			result = "Data with id: " + id + " is deleted";
			tripRepository.deleteById(id);
			
			return ResponseEntity.ok(new MessageResponse<Trip>(true, result));
		} catch (Exception e) {
			result = "Data with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Trip>(false, result));
		}
	}
}
