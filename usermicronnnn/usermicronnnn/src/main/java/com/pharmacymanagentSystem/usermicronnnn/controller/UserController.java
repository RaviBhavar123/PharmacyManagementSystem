package com.pharmacymanagentSystem.usermicronnnn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacymanagentSystem.usermicronnnn.entity.AuthenticationRequest;
import com.pharmacymanagentSystem.usermicronnnn.entity.User;
import com.pharmacymanagentSystem.usermicronnnn.jWt.JwtUtil;
import com.pharmacymanagentSystem.usermicronnnn.service.UserService;
import com.pharmacymanagentSystem.usermicronnnn.service.UserServiceImpl;



@RestController
@CrossOrigin("*")

@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public String token(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Username or Password.");
		}

		return jwtUtil.generateToken(authRequest.getUsername());
	}

	@PostMapping("/add")
	// @PreAuthorize(("hasRole('Admin')") )
	public ResponseEntity<User> add(@RequestBody User user) {
		User user2 = userService.addUser(user);
		return new ResponseEntity<>(user2, HttpStatus.OK);

	}

	@GetMapping("/login/{username}/{password}")

//		@PreAuthorize("hasRole('Passenger')")

	public ResponseEntity<User> passengerLogin(@PathVariable String username, @PathVariable String password) {

		User user = userService.logIn(username, password);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@PutMapping("/update")
	// @PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> update(@RequestBody User userRe) {
		User user2 = userService.updateUser(userRe);
		return new ResponseEntity<>(user2, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{Email}")
	// @PreAuthorize("hasRole('Admin')")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		String s = userService.deletUser(id);
		return new ResponseEntity<>(s, HttpStatus.OK);

	}

	@GetMapping("/get/{Email}")
	// @PreAuthorize("hasRole('User') or hasRole('Admin')")
	public ResponseEntity<User> get(@PathVariable String Email) {
		User use = userService.getUser(Email);
		return new ResponseEntity<>(use, HttpStatus.OK);

	}
	
	
	@GetMapping("/getUser/{id}")
	// @PreAuthorize("hasRole('User') or hasRole('Admin')")
	public ResponseEntity<?> getUserById(@PathVariable String id) {
		User use = userService.getUserById(id);
		return new ResponseEntity<>(use, HttpStatus.OK);

	}
	
	

	@GetMapping("/get")
	// @PreAuthorize("hasRole('User') or hasRole('Admin')")
	public ResponseEntity<List<User>> getAll() {
		List<User> user = userService.getAll();
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
}