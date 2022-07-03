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
import com.hafidz.bus.payload.request.StopRequest;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.StopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/stop")
public class StopController {

	@Autowired
	StopRepository stopRepository;

	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> getAllStops() {
		List<StopRequest> dataResult = new ArrayList<>();
		for (Stop dataArr : stopRepository.findAll()) {
			dataResult.add(new StopRequest(dataArr.getId(), dataArr.getCode(), dataArr.getName(), dataArr.getDetail()));
		}
		return ResponseEntity.ok(new MessageResponse<StopRequest>(true, "Success Retrieving Data", dataResult));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getStopById(@PathVariable(value = "id") Long id) {
		Stop stop= stopRepository.findById(id).get();
		if (stop == null) {
			return ResponseEntity.notFound().build();
		} else {
			StopRequest dataResult = new StopRequest(stop.getId(), stop.getCode(), stop.getName(), stop.getDetail());
			return ResponseEntity.ok(new MessageResponse<StopRequest>(true, "Success Retrieving Data", dataResult));
		}
	}

	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> addStop(@Valid @RequestBody Stop stopRequest) {
		Stop stop = new Stop(stopRequest.getCode(), stopRequest.getName(), stopRequest.getDetail());
		return ResponseEntity.ok(stopRepository.save(stop));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateStop(@PathVariable(value = "id") Long id, @Valid @RequestBody StopRequest stopRequest) {
		Stop stop = stopRepository.findById(stopRequest.getId()).get();
		if(stop == null) {
			return ResponseEntity.notFound().build();
		}
		
		stop.setCode(stopRequest.getCode());
		stop.setDetail(stopRequest.getDetail());
		stop.setName(stopRequest.getName());
		
		Stop updatedStop = stopRepository.save(stop);
		return ResponseEntity.ok(new MessageResponse<Stop>(true, "Success updating stop data", updatedStop));
		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteStop(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			stopRepository.findById(id).get();
			
			result = "Data with id: " + id + " is deleted";
			stopRepository.deleteById(id);
			
			return ResponseEntity.ok(new MessageResponse<Stop>(true, result));
		} catch (Exception e) {
			result = "Data with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Stop>(false, result));
		}
	}

}
