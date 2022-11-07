package com.example.demo.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.TokenDto;
import com.example.demo.models.LoginRequest;
import com.example.demo.service.TokenService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	private static final Logger LOG=LoggerFactory.getLogger(LoginController.class);
	
	
	private final TokenService tokenService;
	private final AuthenticationManager authenticationManager;
	
	LoginController(TokenService tokenService,AuthenticationManager authenticationManager){
		this.tokenService=tokenService;
		this.authenticationManager=authenticationManager;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody LoginRequest userLogin ) {
		
	Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));
		
		return ResponseEntity.ok( new TokenDto (tokenService.generateToken(authentication)));
		
		
		
	}
	
	

} 
