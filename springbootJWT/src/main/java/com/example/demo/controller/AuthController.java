package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.util.JWTUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
@PostMapping	
public String generateToken(@RequestBody AuthRequest authRequest)  throws Exception{
	
	try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
				);
	} catch (AuthenticationException e) {
		// TODO Auto-generated catch block
		throw new InvalidCredentialsException("Invalid username/passoword");
	}
	
	return jwtUtil.generateToken(authRequest.getUserName());
	
}
}
