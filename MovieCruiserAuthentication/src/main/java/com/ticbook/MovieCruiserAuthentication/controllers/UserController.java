package com.ticbook.MovieCruiserAuthentication.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ticbook.MovieCruiserAuthentication.model.User;
import com.ticbook.MovieCruiserAuthentication.services.SecurityTokenGenerator;
import com.ticbook.MovieCruiserAuthentication.services.UserService;

@RestController
@EnableWebMvc
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		try {
			System.out.println(" USER info"+user.getUserId());
			userService.saveUser(user);
			return new ResponseEntity<String>("User Registered Successfully", HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT) ;
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User loginDetail){
		try {
			
			String userId = loginDetail.getUserId();
			String password = loginDetail.getPassword();
			
			if(userId == null || password == null) {
				throw new Exception ("Username or Password cannot be empty");
			}
			
			User user = userService.findByIdAndPassword(userId, password);
			
			if(user == null) {
				throw new Exception("user with given Id does not exists");
			}
			
			String pwd = user.getPassword();
			if(!pwd.equals(password)) {
				throw new Exception("Invalid Login credentials. Please check username and password");
			}
			
			Map<String, String> map = tokenGenerator.generateToken(user);
			System.out.println(map);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.UNAUTHORIZED) ;
		}
	}
	
}
