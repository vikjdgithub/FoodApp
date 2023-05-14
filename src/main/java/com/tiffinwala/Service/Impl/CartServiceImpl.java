package com.tiffinwala.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffinwala.Service.CartService;
import com.tiffinwala.entity.Cart;
import com.tiffinwala.entity.User;
import com.tiffinwala.exception.ResourceNotFoundException;
import com.tiffinwala.foodRepository.CartRepository;
import com.tiffinwala.foodRepository.UserRepository;
import com.tiffinwala.payload.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CartDto saveCart(CartDto cartDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		Cart cart = this.modelMapper.map(cartDto, Cart.class);
		cart.setUser(user);
		Cart savedCart = this.cartRepo.save(cart);
		return this.modelMapper.map(savedCart, CartDto.class);
		
	}

	@Override
	public void deleteCartById(Integer cartId) {
		Cart cart = this.cartRepo.findById(cartId).orElseThrow(()->new ResourceNotFoundException("cart", "cartId", cartId));
		this.cartRepo.delete(cart);
		
	}

	@Override
	public void deleteCartByUserId(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
//		this.cartRepo.deleteByUser(new User(userId));
		
	}

	@Override
	public List<CartDto> getUserCart(Integer userId) {
//		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
//		System.out.println(user);
		
		List<Cart> userCarts = this.cartRepo.findUserCart(userId);		
		System.out.println("Hello: "+userCarts );
		
	return userCarts.stream().map((cart)->this.modelMapper.map(cart, CartDto.class)).collect(Collectors.toList());
//		
		
	}

}
