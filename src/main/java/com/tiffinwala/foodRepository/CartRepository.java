package com.tiffinwala.foodRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tiffinwala.entity.Cart;
import com.tiffinwala.entity.User;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	

	List<Cart> findByUser(User user);
	
	@Query(value="select * from cart where user_id=:userId",nativeQuery = true)
	List<Cart> findUserCart(@Param("userId") Integer userId);
//	
//	@Query(value="delete from cart where user_id=:user_id", nativeQuery = true)
//	@Modifying
//	@Transactional
//	void deleteByUser(User user);
	
	
	
}
