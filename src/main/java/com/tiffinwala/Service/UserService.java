package com.tiffinwala.Service;

import java.util.List;


import com.tiffinwala.payload.UserDto;

public interface UserService {

	UserDto saveUser(UserDto userDto);
	
	UserDto registerNewUser(UserDto userDto);
	
	UserDto updateUser(Integer userId,UserDto userDto);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUserById(Integer userId);
	
	
}
