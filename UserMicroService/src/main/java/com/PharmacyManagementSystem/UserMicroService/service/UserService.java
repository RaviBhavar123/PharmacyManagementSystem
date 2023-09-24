package com.PharmacyManagementSystem.UserMicroService.service;

import java.util.List;

import com.PharmacyManagementSystem.UserMicroService.entity.User;
import com.PharmacyManagementSystem.UserMicroService.exception.UserException;

public interface UserService {

	public User addUser(User user)throws UserException;
	public User updateUser(User uder)throws UserException;
	public void deletUser(String Email)throws UserException;
	public User getUser(String Email)throws UserException;
	public List<User>getAll()throws UserException;

}
