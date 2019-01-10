/**

 * 
 */
package com.ticbook.MovieCruiserApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;

/**
 * @author Manobalan A
 *
 */
public interface MovieEntityRepository extends JpaRepository<MovieEntity , Integer>{
	
List<MovieEntity> findByUserId(String userId);
}
