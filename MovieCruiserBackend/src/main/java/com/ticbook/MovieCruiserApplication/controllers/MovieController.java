/**
 * 
 */
package com.ticbook.MovieCruiserApplication.controllers;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;
import com.ticbook.MovieCruiserApplication.services.MovieService;

import io.jsonwebtoken.Jwts;
/**
 * @author Manobalan A
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path= "/api/v1/movieservice")
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
	public ResponseEntity<?> getAllMovies(final ServletRequest req, ServletResponse res){
		List<MovieEntity> movieList = null;
		ResponseEntity<?> responseEnt = null;
		try {
			final HttpServletRequest request = (HttpServletRequest)req;
			final HttpServletResponse response = (HttpServletResponse)res;
			
			final String token = request.getHeader("authorization").substring(7);
			String userId = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
			
			movieList = movieService.getAllMovies(userId);
			responseEnt = new ResponseEntity<List<MovieEntity>>(movieList, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			responseEnt = new ResponseEntity<String>("\"message\":\""+e.getMessage()+"\"", HttpStatus.CONFLICT);
		}
		return responseEnt;
	}
	
	@PostMapping("/movies/save")
	public ResponseEntity<?> saveMovieDetails(@RequestBody final MovieEntity movie,  HttpServletRequest request, HttpServletResponse response1){
		ResponseEntity<?> response = null;
		
		final String authHeader= request.getHeader("authorization"); 
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
		try {
			movie.setMovieId(movie.getMovieId() + "");
			movie.setUserId(userId);
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
	
	@DeleteMapping("/movies/delete/{movieId}")
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
