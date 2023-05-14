package com.tiffinwala.foodRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinwala.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	Optional<List<Food>> findByFoodNameContaining(String foodName);

	

}
