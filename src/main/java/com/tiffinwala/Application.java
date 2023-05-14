package com.tiffinwala;



import javax.activation.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@SpringBootApplication
public class Application {

//	static final String url = "jdbc:mysql://localhost:3306/food_schema";
//	static final String user = "root";
//	static final String password = "root";
//	@Bean
//	public DriverManagerDataSource dataSource(){
//	System.out.println( url+" "+user+" "+password);
//	DriverManagerDataSource source = new DriverManagerDataSource();
//	source.setUrl(url);source.setUsername(user);
//	source.setPassword(password);
//	return source;
//	}
//	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
	

}
