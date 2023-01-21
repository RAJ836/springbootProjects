package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
