package com.ticbook.MovieCruiserAuthentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticbook.MovieCruiserAuthentication.exceptions.UserAlreadyExistException;
import com.ticbook.MovieCruiserAuthentication.exceptions.UserNotFoundException;
import com.ticbook.MovieCruiserAuthentication.model.User;
import com.ticbook.MovieCruiserAuthentication.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	private final UserRepository userRepo;

	/**
	 * @param userRepo
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistException, UserNotFoundException {
		Optional<User> u1 = userRepo.findById(user.getUserId());
		if(u1.isPresent()) {
			throw new UserAlreadyExistException("User with Id already exists");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findByIdAndPassword(String userId, String password) throws UserNotFoundException {
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if(user == null) {
			throw new UserNotFoundException("UserID and password mismatch");
		}
		return user;
	}
	
	

}
