/**
 * 
 */
package com.ticbook.MovieCruiserApplication.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;
import com.ticbook.MovieCruiserApplication.implementation.MovieServiceImpl;
import com.ticbook.MovieCruiserApplication.repositories.MovieEntityRepository;

/**
 * @author Manobalan A
 *
 */
public class MovieServicesImplTest {
	
	@Spy
	private MovieEntityRepository movieRepository;
	@InjectMocks
	private MovieServiceImpl movieService;
	private List<MovieEntity> movieList = new ArrayList<MovieEntity>();
	Optional<MovieEntity> optional;
	Optional<MovieEntity> empOptional;
	MovieEntity movie1 = null;
	MovieEntity movie2 = null;
	
	@Before
	public void initiaModel() {
		MockitoAnnotations.initMocks(this);
		movie1 = new MovieEntity();
		movie1.setId(1);
		movie1.setMovieName("The MEG 2018");
		movie1.setMovieComments("After escaping an attack by what he claims was a 70-foot shark, Jonas Taylor must confront his fears to save those trapped in a sunken submersible.");
		movie1.setPosterPath("https://www.imdb.com/title/tt4779682/mediaviewer/rm1110263296");
		movieList.add(movie1);
		movie2 = new MovieEntity();
		movie2.setId(2);
		movie2.setMovieName("Hotel Transylvania 3: Summer Vacation (2018)");
		movie2.setMovieComments("Count Dracula and company participate in a cruise for sea-loving monsters, unaware that their boat is being commandeered by the monster-hating Van Helsing family.");
		movie2.setPosterPath("https://www.imdb.com/title/tt5220122/mediaviewer/rm1546076160");
		movieList.add(movie2);
		optional = Optional.of(movie1);
		empOptional = Optional.empty();
	}
	@Test
	public void getMovieByIdTest() {
		try {
			when(movieRepository.findById(Mockito.anyInt())).thenReturn(optional);
			assertEquals(movie1.getId(), movieService.getMovieById(movie1.getId()).getId());
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void getMovieByIdExcepTest() throws MovieNotFoundException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(empOptional);
		movieService.getMovieById(67);
	}
	
	@Test
	public void getAllMoviesTest() throws MovieNotFoundException {
		when(movieRepository.findAll()).thenReturn(movieList);
		assertEquals(2,movieService.getAllMovies().size());
	}
	
	@Test
	public void saveMovieTest() throws MovieNotFoundException, MovieAlreadyExistsException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(empOptional);
		when(movieRepository.save(Mockito.mock(MovieEntity.class))).thenReturn(movie1);
		assertTrue(movieService.saveMovie(movie1));
	}
	
	@Test(expected = MovieAlreadyExistsException.class)
	public void saveMovieExcepTest() throws MovieAlreadyExistsException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie1));
		movieService.saveMovie(movie1);
	}
	
	@Test
	public void updateMovieTest() throws MovieNotFoundException, MovieAlreadyExistsException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie1));
		when(movieRepository.save(Mockito.mock(MovieEntity.class))).thenReturn(movie1);
		assertEquals(movie1.getId(), movieService.updateMovie(movie1).getId());
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void updateMovieExcepTest() throws MovieAlreadyExistsException, MovieNotFoundException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(empOptional);
		movieService.updateMovie(movie1);
	}
	
	@Test
	public void deleteMovieTest() throws MovieNotFoundException, MovieAlreadyExistsException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie1));
		Mockito.doNothing().when(movieRepository).deleteById(Mockito.anyInt());
		assertTrue(movieService.deleteMovieById(movie1.getId()));
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void deleteMovieExcepTest() throws MovieNotFoundException, MovieAlreadyExistsException {
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(empOptional);
		Mockito.doNothing().when(movieRepository).deleteById(Mockito.anyInt());
		movieService.deleteMovieById(movie1.getId());
	}
	

}
