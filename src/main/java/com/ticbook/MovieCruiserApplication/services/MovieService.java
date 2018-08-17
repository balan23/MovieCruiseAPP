/**
 * 
 */
package com.ticbook.MovieCruiserApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieCruiser.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;

/**
 * @author Manobalan A
 * 
 * Interface provides all the servicing method for the movie cruiser app
 *
 */
public interface MovieService {
	
	/**
	 * @param id
	 * @return
	 * @throws MovieNotFoundException
	 */
	public MovieEntity getMovieById(int id ) throws MovieNotFoundException;
	/**
	 * @return
	 * @throws MovieNotFoundException
	 */
	public List<MovieEntity> getAllMovies() throws MovieNotFoundException;
	/**
	 * @param movieEntity
	 * @return
	 * @throws MovieAlreadyExistsException
	 */
	public boolean saveMovie(MovieEntity movieEntity) throws MovieAlreadyExistsException;
	/**
	 * @param movieEntity
	 * @return
	 * @throws MovieNotFoundException
	 */
	public MovieEntity updateMovie(MovieEntity movieEntity) throws MovieNotFoundException;
	/**
	 * @param id
	 * @return
	 * @throws MovieNotFoundException
	 */
	public boolean deleteMovieById(int id) throws MovieNotFoundException;
	
	

}
