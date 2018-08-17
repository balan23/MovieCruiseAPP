/**

 * 
 */
package com.ticbook.MovieCruiserApplication.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.MovieCruiser.entities.MovieEntity;

import junit.framework.Assert;

/**
 * @author Manobalan A
 *
 */
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieEntityRepositoryTest{
	
	@Autowired
	MovieEntityRepository movieEntityRepo;
	
	
	MovieEntity movie = null;
	MovieEntity movie2 = null;
	List<MovieEntity> movieList = new ArrayList<>();
	
	@Before
	public void populateMovie() {
		movie = new MovieEntity();
		movie.setMovieCode(1);
		movie.setMovieName("The MEG 2018");
		movie.setMovieComments("After escaping an attack by what he claims was a 70-foot shark, Jonas Taylor must confront his fears to save those trapped in a sunken submersible.");
		movie.setPosterPath("https://www.imdb.com/title/tt4779682/mediaviewer/rm1110263296");
		movieList.add(movie);
		movie2 = new MovieEntity();
		movie2.setMovieCode(2);
		movie2.setMovieName("Hotel Transylvania 3: Summer Vacation (2018)");
		movie2.setMovieComments("Count Dracula and company participate in a cruise for sea-loving monsters, unaware that their boat is being commandeered by the monster-hating Van Helsing family.");
		movie2.setPosterPath("https://www.imdb.com/title/tt5220122/mediaviewer/rm1546076160");
		movieList.add(movie2);
		
	}
	
	@Test
	public void saveMovieTest() {
		assertEquals(1, movieEntityRepo.save(movie).getMovieCode());
	}
	
	@Test
	public void findMovieByIdTest() {
		movieEntityRepo.save(movie);
		Optional<MovieEntity> movie = movieEntityRepo.findById(1);
		assertTrue(movie.isPresent());
		assertEquals(1,movie.get().getMovieCode());
	}
	
	@Test
	public void deleteMovieByIdTest() {
		movieEntityRepo.save(movie);
		movieEntityRepo.deleteById(movie.getMovieCode());
		Optional<MovieEntity> movie = movieEntityRepo.findById(5);
		assertFalse(movie.isPresent());
	}
	
	@Test
	public void getAllMovieTest() {
		movieEntityRepo.save(movie);
		movieEntityRepo.save(movie2);
		assertEquals(2, movieEntityRepo.findAll().size());
	}
	

}
