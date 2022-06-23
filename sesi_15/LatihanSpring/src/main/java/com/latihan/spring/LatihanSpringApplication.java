package com.latihan.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.latihan.spring.model.Address;
import com.latihan.spring.model.User;
import com.latihan.spring.repository.AddressRepository;
import com.latihan.spring.repository.UserRepository;

@SpringBootApplication
public class LatihanSpringApplication implements CommandLineRunner {
	private final Logger LOG = LoggerFactory.getLogger(LatihanSpringApplication.class);

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LatihanSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create a user
		User user = new User("haaha@yahoo.com", "Hafidz Firmansyah", "inipassword");

		// create an address for the user
		Address address = new Address("Solo", "Indonesia", "Jawa Tengah","Jl. Adisucipto", "57271");

		// set child reference (address) in parent entity (user)
		user.setAddress(address);

		// set parent reference (user) in child entity (address)
		address.setUsers(user);

		// save the user (parent)
		userRepository.save(user);

		// save the address (child)
		addressRepository.save(address);

		// show all user
		List<User> userAll = userRepository.findAll();
		LOG.info("Users:" + userAll);

		// show all address
		List<Address> addressAll = addressRepository.findAll();
		LOG.info("Courses:" + addressAll);
	}

}
