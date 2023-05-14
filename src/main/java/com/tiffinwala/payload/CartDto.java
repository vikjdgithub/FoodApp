package com.tiffinwala.payload;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tiffinwala.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

	
	private Integer id;
  
	@NotBlank
	private String foodName;
   
	@NotBlank
	private Float foodPrice;
 
	@NotBlank
	private String imageUrl;
    
    
    private UserDto userDto;
    
  
	private LocalDateTime createdDate;
 
	
	private String createdBy;
	
	
	private LocalDateTime updatedDate;
	
	
	private String updatedBy;

	
	
}
