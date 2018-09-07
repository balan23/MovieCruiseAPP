/**
 * 
 */
package com.ticbook.MovieCruiserApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;
import com.ticbook.MovieCruiserApplication.services.MovieService;

/**
 * @author Manobalan A
 *
 */
@CrossOrigin
@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<?> getMovieDetails(@PathVariable("movieId") final int movieId ){
		MovieEntity movie = null;
		ResponseEntity<?> response = null;
		try {
			movie = movieService.getMovieById(movieId);
			response = new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			response = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@GetMapping("/movies/all")
	public ResponseEntity<?> getAllMovies(){
		List<MovieEntity> movieList = null;
		ResponseEntity<?> response = null;
		try {
			movieList = movieService.getAllMovies();
			response = new ResponseEntity<List<MovieEntity>>(movieList, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			response = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@PostMapping("/movies/save")
	public ResponseEntity<?> saveMovieDetails(@RequestBody final MovieEntity movie){
		ResponseEntity<?> response = null;
		try {
			movieService.saveMovie(movie);
			response = new ResponseEntity<MovieEntity>(movie, HttpStatus.CREATED);
		} catch (MovieAlreadyExistsException e) {
			response = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@PutMapping("/movies/update")
	public ResponseEntity<?> updateMovieDetails(@RequestBody MovieEntity movie){
		ResponseEntity<?> response = null;
		try {
			movieService.updateMovie(movie);
			response = new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			response = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@PostMapping("/movies/delete/{movieId}")
	public ResponseEntity<?> deleteMovieDetails(@PathVariable("movieId") int movieId ){
		ResponseEntity<?> response = null;
		try {
			movieService.deleteMovieById(movieId);
			response = new ResponseEntity<MovieEntity>(HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			response = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return response;
	}

}
