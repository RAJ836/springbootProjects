package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@SpringBootApplication
public class SpringbootJwtApplication {
	
	@Autowired
	private UserRepo repo;
	
	@PostConstruct
	public void initUsers() {
		System.out.println("init method !");
		User user1 =new User();
//		user1.setId(1);
		user1.setUserName("raj");
		user1.setPassword("raj");
		user1.setEmail("abc@gmail.com");
		repo.save(user1);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
	}

}
