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
import com.hafidz.bus.payload.request.BusCustomRequest;
import com.hafidz.bus.payload.request.BusRequest;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.AgencyRepository;
import com.hafidz.bus.repository.BusRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@GetMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAll() {
		List<BusRequest> dataArrResult = new ArrayList<>();
		for (Bus dataArr : busRepository.findAll()) {
			dataArrResult.add(new BusRequest(dataArr.getId(), dataArr.getCode(), dataArr.getCapacity(),
					dataArr.getUsedCapacity(), dataArr.getAgency().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<BusRequest>(true, "Success Retrieving Data", dataArrResult));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getBusByAgencyId(@PathVariable(value = "id") Long id) {
		Bus bus = busRepository.findById(id).get();
		if (bus == null) {
			return ResponseEntity.notFound().build();
		} else {
			BusRequest dataResult = new BusRequest(bus.getId(), bus.getCode(), bus.getCapacity(),
					bus.getUsedCapacity(), bus.getAgency().getId());
			return ResponseEntity.ok(new MessageResponse<BusRequest>(true, "Success Retrieving Data", dataResult));
		}
	}
	
	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addBus(@Valid @RequestBody BusRequest busRequest) {
		Agency agency = agencyRepository.findById(busRequest.getAgencyId()).get();
		Bus bus= new Bus(busRequest.getCode(), busRequest.getCapacity(), busRequest.getUsedCapacity(), agency);
		return ResponseEntity
				.ok(new MessageResponse<Bus>(true, "Success Adding Data", busRepository.save(bus)));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addBusByUserId(@PathVariable(value = "id") Long id,
			@Valid @RequestBody BusCustomRequest busCustomRequest) {
		Agency agency = agencyRepository.findByOwnerUser(id);
		Bus bus = new Bus(busCustomRequest.getCode(), busCustomRequest.getCapacity(), busCustomRequest.getMake(),
				agency);
		return ResponseEntity.ok(busRepository.save(bus));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteBus(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			busRepository.findById(id).get();

			result = "Success Deleting Data with Id: " + id;
			busRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<Bus>(true, result));
		} catch (Exception e) {
			result = "Data with Id: " + id + " Not Found";
			return ResponseEntity.ok(new MessageResponse<Bus>(false, result));
		}
	}

}
