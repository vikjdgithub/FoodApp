package com.tiffinwala.Service;

import java.util.List;

import com.tiffinwala.entity.User;
import com.tiffinwala.payload.CartDto;

public interface CartService {

	
	CartDto saveCart(CartDto cartDto , Integer userId);
	
	void deleteCartById(Integer cartId);
	
	void deleteCartByUserId(Integer userId);
	
	List<CartDto> getUserCart(Integer userId);
	
}
