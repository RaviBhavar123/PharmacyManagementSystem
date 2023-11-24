package com.pharmacymanagentSystem.usermicronnnn.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pharmacymanagentSystem.usermicronnnn.entity.User;
import com.pharmacymanagentSystem.usermicronnnn.repository.UserRepo;






@Service
public class CustomUserDetailsService implements UserDetailsService  {
//
	@Autowired
	private UserRepo userRepo;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username).get();
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.getRole().toString())));

	}
}

