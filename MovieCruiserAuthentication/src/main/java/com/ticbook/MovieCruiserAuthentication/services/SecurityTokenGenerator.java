package com.ticbook.MovieCruiserAuthentication.services;

import java.util.Map;

import com.ticbook.MovieCruiserAuthentication.model.User;

public interface SecurityTokenGenerator {
	
	Map<String, String> generateToken(User user);

}
