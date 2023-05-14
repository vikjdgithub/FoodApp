package com.tiffinwala.payload;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {

	
    private Long foodId;
	
	
    private String foodName;
	

    private Float foodPrice;
	
	
    private String imageUrl;
	
	
	private String activeSW;
	
	
	private LocalDateTime createdDate;
	
	
	private String createdBy;
	
	
	private LocalDateTime updatedDate;
	
	
	private String updatedBy;
}
