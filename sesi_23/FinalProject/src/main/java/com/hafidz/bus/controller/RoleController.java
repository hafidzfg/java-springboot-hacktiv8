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

import com.hafidz.bus.model.Role;
import com.hafidz.bus.payload.response.MessageResponse;
import com.hafidz.bus.repository.RoleRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> getAllRole() {
		List<Role> dataResult = new ArrayList<>();
		for (Role dataArr : roleRepository.findAll()) {
			dataResult.add(new Role(dataArr.getId(), dataArr.getName()));
		}
		return ResponseEntity.ok(new MessageResponse<Role>(true, "Success Retrieving Data", dataResult));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getRoleById(@PathVariable(value = "id") int id) {
		Role role= roleRepository.findById(id).get();
		if(role == null) {
			return ResponseEntity.notFound().build();
		} else { 
			Role dataResult = new Role(role.getId(), role.getName());
			return ResponseEntity.ok(new MessageResponse<Role>(true, "Success Retrieving Data", dataResult));
			
		}
	}
	
	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> addRole(@Valid @RequestBody Role roleRequest) {
		Role role = new Role(roleRequest.getId(), roleRequest.getName());
		return ResponseEntity.ok(roleRepository.save(role));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateRole(@PathVariable(value = "id") Long id, @Valid @RequestBody Role roleRequest) {
		Role role = roleRepository.findById(roleRequest.getId()).get();
		if(role == null) {
			return ResponseEntity.notFound().build();
		}
		
		role.setId(roleRequest.getId());
		role.setName(roleRequest.getName());
		
		Role updatedRole = roleRepository.save(role);
		return ResponseEntity.ok(new MessageResponse<Role>(true, "Success updating role data", updatedRole));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteRole(@PathVariable(value = "id") int id) {
		String result = "";
		try {
			roleRepository.findById(id).get();
			
			result = "Data with id: " + id + " is deleted";
			roleRepository.deleteById(id);
			
			return ResponseEntity.ok(new MessageResponse<Role>(true, result));
		} catch (Exception e) {
			result = "Data with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Role>(false, result));
		}
	}

}
