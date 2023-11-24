package com.pharmacymanagentSystem.usermicronnnn.service;

import java.util.List;

import com.pharmacymanagentSystem.usermicronnnn.entity.User;
import com.pharmacymanagentSystem.usermicronnnn.exception.UserException;



public interface UserService {

	public User addUser(User user) throws UserException;

	public User updateUser(User uder) throws UserException;

	public String deletUser(String id) throws UserException;

	public User getUser(String Email) throws UserException;

	public List<User> getAll() throws UserException;
	
	User getUserById(String id);
	
	

}