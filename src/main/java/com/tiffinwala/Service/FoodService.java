package com.tiffinwala.Service;

import java.util.List;

import com.tiffinwala.payload.FoodDto;


public interface FoodService {

	FoodDto saveFood(FoodDto foodDto);
	
	FoodDto updateFood(Integer foodId,FoodDto foodDto);
	
	FoodDto getFoodById(Integer foodId);
	
	List<FoodDto> getAllFood();
	
	List<FoodDto> getAllFoodByName(String foodName);
	
	void deleteFoodById(Integer foodId);
}
