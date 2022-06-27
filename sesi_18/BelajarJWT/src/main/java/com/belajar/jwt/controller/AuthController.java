package com.belajar.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.belajar.jwt.config.JwtToken;
import com.belajar.jwt.model.JwtRequest;
import com.belajar.jwt.model.JwtResponse;
import com.belajar.jwt.service.JwtUserDetailsService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@CrossOrigin
@Tag(name = "Authentication", description = "API for authenticate")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtToken jwtToken;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Operation(summary = "Authenticate", description = "Authenticate user credentials", tags = { "authenticate" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = JwtResponse.class))) })
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtUserDetailsService

				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtToken.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception {

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {

			throw new Exception("USER_DISABLED", e);

		} catch (BadCredentialsException e) {

			throw new Exception("INVALID_CREDENTIALS", e);

		}

	}

}
