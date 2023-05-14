package com.tiffinwala.payload;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.tiffinwala.entity.Cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

     private Integer userId;
    
     @NotBlank
	 private String userName;
     
     @NotBlank
     @Size(min=4,max=8,message="password must be greater than 4 and less than 8 character ")
	 private String password;
     
     @NotBlank
     @Size(min=4,max=8,message="password must be greater than 4 and less than 8 character ")
	 private String confirmPassword;
     
     @NotBlank
     @Email
	 private String emailId;
     
	 private long mobile;
     
    
	 
}
