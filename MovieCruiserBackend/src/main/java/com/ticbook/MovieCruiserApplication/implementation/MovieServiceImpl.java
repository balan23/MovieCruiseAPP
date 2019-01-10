package com.ticbook.MovieCruiserApplication.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;
import com.ticbook.MovieCruiserApplication.repositories.MovieEntityRepository;
import com.ticbook.MovieCruiserApplication.services.MovieService;

/**
 * @author Manobalan A
 *
 */
@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieEntityRepository movieEntityRepository;

	@Override
	public MovieEntity getMovieById(int id) throws MovieNotFoundException {
		
		Optional<MovieEntity> movieEntiy = movieEntityRepository.findById(id);
		if(!movieEntiy.isPresent()) {
			throw new MovieNotFoundException("Movie with given id is not Present");
		}
		return movieEntiy.get();
	}

	@Override
	public List<MovieEntity> getAllMovies(String userId) throws MovieNotFoundException {
		return movieEntityRepository.findByUserId(userId);
	}

	@Override
	public boolean saveMovie(MovieEntity movieEntity) throws MovieAlreadyExistsException {
		Optional<MovieEntity> movieEntiyById = movieEntityRepository.findById(movieEntity.getId());
		if(movieEntiyById.isPresent()) {
			throw new MovieAlreadyExistsException("Movie with given id is already Present");
		}else {
			movieEntityRepository.save(movieEntity);
		}
		return true;
	}

	@Override
	public MovieEntity updateMovie(MovieEntity movieEntity) throws MovieNotFoundException {
		Optional<MovieEntity> movieEntiyById = movieEntityRepository.findById(movieEntity.getId());
		if(!movieEntiyById.isPresent()) {
			throw new MovieNotFoundException("Movie with given id is not Present");
		}else {
			movieEntityRepository.save(movieEntity);
		}
		return movieEntity;
	}

	@Override
	public boolean deleteMovieById(int id) throws MovieNotFoundException {
		Optional<MovieEntity> movieEntiyById = movieEntityRepository.findById(id);
		if(!movieEntiyById.isPresent()) {
			throw new MovieNotFoundException("Movie with given id is not Present");
		}else {
			movieEntityRepository.deleteById(id);
		}
		return true;
	}

}
