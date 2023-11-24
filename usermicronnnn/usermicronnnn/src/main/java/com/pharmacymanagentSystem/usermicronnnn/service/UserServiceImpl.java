package com.pharmacymanagentSystem.usermicronnnn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacymanagentSystem.usermicronnnn.entity.User;
import com.pharmacymanagentSystem.usermicronnnn.exception.UserException;
import com.pharmacymanagentSystem.usermicronnnn.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) throws UserException {
		return userRepo.save(user);

	}

	public User logIn(String username, String password) {
		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Invalid password or username"));
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid password or username");
		}
		return user;
	}

	@Override
	public User updateUser(User user) throws UserException {
		User userRe = userRepo.findById(user.getId()).orElseThrow(() -> new UserException("Invalid user Id"));
		userRe.setName(user.getName());
		userRe.setContact(user.getContact());
		userRe.setUsername(user.getUsername());
		userRe.setPassword(user.getPassword());
		userRe.setRole(user.getRole());
		return userRepo.save(userRe);
	}

	@Override
	public String deletUser(String id) throws UserException {
		userRepo.deleteById(id);
		return "Successfully Deleted";

	}

	@Override
	public User getUser(String Email) throws UserException {
		User user = userRepo.findByUsername(Email).orElseThrow(() -> new RuntimeException("User not found"));
		return user;
	}

	@Override
	public List<User> getAll() throws UserException {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String id) {
		User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("No User with this id"));
		return user;
	}

}