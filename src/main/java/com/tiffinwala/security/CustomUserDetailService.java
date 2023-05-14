package com.tiffinwala.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tiffinwala.entity.User;
import com.tiffinwala.exception.ResourceNotFoundException;
import com.tiffinwala.foodRepository.UserRepository;

import lombok.ToString;


@ToString
@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("user", "username", username));
		
		System.out.println(user);
	
		return user;
	}

}
