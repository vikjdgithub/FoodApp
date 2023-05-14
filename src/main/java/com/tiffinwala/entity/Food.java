package com.tiffinwala.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.annotation.HttpConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="FOOD_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="food_id")
    private Integer foodId;
	
	@Column(name="food_name")
    private String foodName;
	
	@Column(name="food_price")
    private Float foodPrice;
	
	@Column(name="image_url")
    private String imageUrl;
	
	@Column(name="active_sw")
	private String activeSW;
	
	@Column(name="created_date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_date")
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	
	
	
	

}
