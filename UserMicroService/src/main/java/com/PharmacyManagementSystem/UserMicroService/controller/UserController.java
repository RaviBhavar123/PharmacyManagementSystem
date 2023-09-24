package com.PharmacyManagementSystem.UserMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PharmacyManagementSystem.UserMicroService.entity.User;
import com.PharmacyManagementSystem.UserMicroService.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) {
		User user2 = userService.addUser(user);
		return new ResponseEntity<>(user2, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User userRe) {
		User user2 = userService.updateUser(userRe);
		return new ResponseEntity<>(user2, HttpStatus.OK);

	}

	@DeleteMapping("/delet/{Email}")
	public ResponseEntity<String> delet(@PathVariable String Email) {
		userService.deletUser(Email);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@GetMapping("/get/{Email}")
	public ResponseEntity<User> get(@PathVariable String Email) {
		User use = userService.getUser(Email);
		return new ResponseEntity<>(use, HttpStatus.OK);

	}
	@GetMapping("/get")
	public ResponseEntity<List<User>>getAll(){
		List<User>user=userService.getAll();
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
}
