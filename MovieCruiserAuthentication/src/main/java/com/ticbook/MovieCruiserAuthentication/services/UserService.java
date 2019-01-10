package com.ticbook.MovieCruiserAuthentication.services;

import com.ticbook.MovieCruiserAuthentication.exceptions.UserAlreadyExistException;
import com.ticbook.MovieCruiserAuthentication.exceptions.UserNotFoundException;
import com.ticbook.MovieCruiserAuthentication.model.User;

public interface UserService {

	boolean saveUser(User user) throws UserAlreadyExistException, UserNotFoundException;
	public User findByIdAndPassword(String userId, String password) throws UserNotFoundException;
	
}
