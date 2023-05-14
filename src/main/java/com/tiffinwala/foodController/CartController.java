package com.tiffinwala.foodController;

import java.util.List;
import java.util.Optional;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiffinwala.Service.CartService;
import com.tiffinwala.entity.Cart;
import com.tiffinwala.entity.User;
import com.tiffinwala.exception.ResourceNotFoundException;
import com.tiffinwala.foodRepository.UserRepository;
import com.tiffinwala.payload.ApiResponse;
import com.tiffinwala.payload.CartDto;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins="http://localhost:4200")
public class CartController {
    
	@Autowired
	private CartService cartService;

	@PostMapping("/save/{userId}")
	public ResponseEntity<CartDto> saveUserCart(@RequestBody CartDto cartDto, @PathVariable Integer userId){
		CartDto savedCart = this.cartService.saveCart(cartDto, userId);
		return new ResponseEntity<CartDto>(savedCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{cartId}")
	public ResponseEntity<List<CartDto>> getUserCart(@PathVariable Integer userId){
		List<CartDto> userCarts = this.cartService.getUserCart(userId);
		return new ResponseEntity<List<CartDto>>(userCarts,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<ApiResponse> deleteUserCart(@PathVariable Integer userId){
	           this.cartService.deleteCartById(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("cart Deleted successfuly",true),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserCart/{userId}")
	public ResponseEntity<List<CartDto>> getCartByUser( @PathVariable Integer userId){
		List<CartDto> userCartDtos = this.cartService.getUserCart(userId);
		
		return new ResponseEntity<List<CartDto>>(userCartDtos,HttpStatus.OK);
	}
	 
}
