package com.tiffinwala.foodController;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiffinwala.Service.UserService;

import com.tiffinwala.entity.User;
import com.tiffinwala.payload.ApiResponse;
import com.tiffinwala.payload.UserDto;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
 
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/save")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {
		
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
	    userDto.setConfirmPassword(passwordEncoder.encode(userDto.getConfirmPassword()));
	
		UserDto savedUser = this.userService.saveUser(userDto);
		return new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser( @Valid @PathVariable Integer userId, @RequestBody UserDto userDto){
		
		UserDto updatedUser = this.userService.updateUser(userId, userDto);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
	}
	
	@GetMapping("/find/{userId}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Integer userId){
		
		UserDto userDto = this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUserById( @PathVariable Integer userId) {
		System.out.println("in delete controller");
		this.userService.deleteUserById(userId);
		return new  ResponseEntity(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser(){
		System.out.println("userController");
		
		return ResponseEntity.ok(this.userService.getAllUser());
//		List<UserDto> allUser = this.userService.getAllUser();
//		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
	}
}
