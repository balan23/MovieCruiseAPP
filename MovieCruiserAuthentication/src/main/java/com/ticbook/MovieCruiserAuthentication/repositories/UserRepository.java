/**

 * 
 */
package com.ticbook.MovieCruiserAuthentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticbook.MovieCruiserAuthentication.model.User;

/**
 * @author Manobalan A
 *
 */
public interface UserRepository extends JpaRepository<User , String>{
	
	User findByUserIdAndPassword(String userId, String password);
	

}
