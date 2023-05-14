package com.tiffinwala.foodController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiffinwala.Service.FoodService;
import com.tiffinwala.config.AppConstant;
import com.tiffinwala.entity.Food;
import com.tiffinwala.payload.ApiResponse;
import com.tiffinwala.payload.FoodDto;
import com.tiffinwala.payload.UserDto;


@RestController
@RequestMapping("/food")
@CrossOrigin(value ="http://localhost:4200")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("/save")
	public ResponseEntity<FoodDto> saveUser( @RequestBody FoodDto foodDto) {
		FoodDto savedFood = this.foodService.saveFood(foodDto);
		return new ResponseEntity<FoodDto>(savedFood,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{foodId}")
	public ResponseEntity<FoodDto> updateUser( @PathVariable Integer foodId, @RequestBody FoodDto foodDto){
		FoodDto updatedFood = this.foodService.updateFood(foodId, foodDto);
		return new ResponseEntity<FoodDto>(updatedFood,HttpStatus.OK);
	}
	
	@GetMapping("/search/{foodId}")
	public ResponseEntity<FoodDto> findUserById(@PathVariable Integer foodId){
		FoodDto foodDto = this.foodService.getFoodById(foodId);
		return new ResponseEntity<FoodDto>(foodDto,HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<FoodDto>> findUserById(
			@RequestParam(value="foodName") String foodName,
			@RequestParam(value="pageNumber",defaultValue = AppConstant.PAGE_NUMBER ,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize
			
			){
		List<FoodDto> foods = this.foodService.getAllFoodByName(foodName);
		return new ResponseEntity<List<FoodDto>>(foods,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<ApiResponse> deleteUserById( @PathVariable Integer foodId) {
		System.out.println("in delete controller");
		this.foodService.deleteFoodById(foodId);
		return new  ResponseEntity(new ApiResponse("Food removed successfully from the database",true),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<FoodDto>> getAllUser(){
		System.out.println("controller called");
		List<FoodDto> allUser = this.foodService.getAllFood();
		return new ResponseEntity<List<FoodDto>>(allUser,HttpStatus.OK);
	}

	
	
	
}
