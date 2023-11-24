package com.PharmacyManagementSystem.UserMicroService.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PharmacyManagementSystem.UserMicroService.entity.User;
import com.PharmacyManagementSystem.UserMicroService.exception.UserException;
import com.PharmacyManagementSystem.UserMicroService.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService   {

    private final UserRepo userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    
    


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userRepository.findByEmail(email);
	        
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        // Create a set of roles/authorities for the user
	        Set<GrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // All users have ROLE_USER by default
	        if (user.getRole().equals("Admin")) {
	            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        }
	        if (user.getRole().equals("Doctor")) {
	            authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
	        }

	        // Construct the UserDetails object with the user's information and roles
	        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
	                user.getEmail(),
	                user.getPassword(), // You should store password hashes in the database
	                authorities
	        );

	        return userDetails;
		
	}
}






    




