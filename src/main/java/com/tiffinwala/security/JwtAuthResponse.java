package com.tiffinwala.security;

import com.tiffinwala.payload.UserDto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}
