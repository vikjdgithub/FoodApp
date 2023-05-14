package com.tiffinwala.foodRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinwala.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String userName);
}
