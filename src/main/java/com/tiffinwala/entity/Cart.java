package com.tiffinwala.entity;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart")
@Getter
@Setter
@NoArgsConstructor

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
  
	@Column(name="NAME")
	private String foodName;
   
	@Column(name="PRICE")
	private Float foodPrice;
 
    @Column(name="IMAGE_URL")
	private String imageUrl;
    
   
    @Column(name="CREATED_DATE" , updatable=false)
    @CreationTimestamp
	private LocalDateTime createdDate;
 
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	
	

	
	 
	
}
