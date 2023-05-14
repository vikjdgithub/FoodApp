package com.tiffinwala.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tiffinwala.Service.UserService;
import com.tiffinwala.entity.Role;
import com.tiffinwala.entity.User;
import com.tiffinwala.exception.ResourceNotFoundException;
import com.tiffinwala.foodRepository.CartRepository;
import com.tiffinwala.foodRepository.UserRepository;
import com.tiffinwala.payload.UserDto;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
		
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		
		user.setUsername(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setConfirmPassword(userDto.getConfirmPassword());
		user.setMobile(userDto.getMobile());
	    User updatedUser = this.userRepo.save(user);
	   return  this.modelMapper.map(updatedUser, UserDto.class);
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		return this.modelMapper.map(user, UserDto.class);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		System.out.println("userService");
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map((user)->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		System.out.println(userDtos);
		return userDtos;
	}

	@Override
	public void deleteUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// roles
//		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
//
//		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

}
