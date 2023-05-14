package com.tiffinwala.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffinwala.Service.FoodService;
import com.tiffinwala.entity.Food;
import com.tiffinwala.exception.ResourceNotFoundException;
import com.tiffinwala.foodRepository.FoodRepository;
import com.tiffinwala.payload.FoodDto;
@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private ModelMapper modeMapper;
	
	@Override
	public FoodDto saveFood(FoodDto foodDto) {
	Food food = this.modeMapper.map(foodDto, Food.class);
	Food savedFood = this.foodRepo.save(food);
	return this.modeMapper.map(food, FoodDto.class);
		
	}

	@Override
	public FoodDto updateFood(Integer foodId, FoodDto foodDto) {
		Food food = this.foodRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("food", "foodId", foodId));
		food.setFoodName(foodDto.getFoodName());
		food.setFoodPrice(foodDto.getFoodPrice());
		food.setImageUrl(foodDto.getImageUrl());
		Food savedFood = this.foodRepo.save(food);
		return this.modeMapper.map(savedFood, FoodDto.class);
	
	}

	@Override
	public FoodDto getFoodById(Integer foodId) {
		Food food = this.foodRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("food", "foodId", foodId));
		return this.modeMapper.map(food, FoodDto.class);
		
	}

	@Override
	public List<FoodDto> getAllFood() {
		System.out.println("service called");
		List<Food> foods = this.foodRepo.findAll();
		return foods.stream().map((food)->this.modeMapper.map(food, FoodDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public void deleteFoodById(Integer foodId) {
		Food food = this.foodRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("food", "foodId", foodId));
		this.foodRepo.delete(food);
		
	}

	@Override
	public List<FoodDto> getAllFoodByName(String foodName) {
		
		List<Food> foods = this.foodRepo.findByFoodNameContaining(foodName).orElseThrow(()->new ResourceNotFoundException("food", "foodName", foodName));
		return foods.stream().map((food)->this.modeMapper.map(foods, FoodDto.class)).collect(Collectors.toList());
		
	}

}
