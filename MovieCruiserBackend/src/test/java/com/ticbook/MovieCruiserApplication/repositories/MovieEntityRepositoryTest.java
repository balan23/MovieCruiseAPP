/**

 * 
 */
package com.ticbook.MovieCruiserApplication.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticbook.MovieCruiserApplication.entities.MovieEntity;

/**
 * @author Manobalan A
 *
 */
//@RunWith(SpringRunner.class)
////@Transactional
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieEntityRepositoryTest{/*
	
	@Autowired
	private transient MovieEntityRepository movieEntityRepo;

	
public void setRepo(final MovieEntityRepository movieEntityRepo) {
	this.movieEntityRepo= movieEntityRepo;
}
	
	@Test
	public void saveMovieTest() throws Exception {
		final MovieEntity mov = addMovie();
		assertThat(mov.getId()).isEqualTo(5);
	}

	*//**
	 * @return
	 *//*
	private MovieEntity addMovie() {
		MovieEntity movie = new MovieEntity();
		movie.setId(5);
		movie.setMovieName("seemaraja");
		movie.setMovieComments("Siva's great movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity mov=  movieEntityRepo.getOne(5);
		return mov;
	}
	
	@Test
	public void updateMovieTest() throws Exception {
		MovieEntity movie = new MovieEntity();
		movie.setId(1);
		movie.setMovieName("KaatrinMozhi");
		movie.setMovieComments("Rated 5.0");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity uMov=  movieEntityRepo.getOne(1);
		assertEquals(uMov.getMovieName(),"KaatrinMozhi");
		uMov.setMovieComments("Jothika great movie");
		movieEntityRepo.save(uMov);
		final MovieEntity mov=  movieEntityRepo.getOne(1);
		assertEquals(mov.getMovieComments(),"Jothika great movie");
	}	

	
	@Test
	public void deleteMovieByIdTest() {
		
		MovieEntity movie = new MovieEntity();
		movie.setId(5);
		movie.setMovieName("seemaraja");
		movie.setMovieComments("Siva's great movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity mov=  movieEntityRepo.getOne(5);
		assertEquals("seemaraja", mov.getMovieName());
		movieEntityRepo.delete(mov);
		assertEquals(Optional.empty(),movieEntityRepo.findById(5));

	}
	
	@Test
	public void findMovieByIdTest() {		
		
		MovieEntity movie = new MovieEntity();
		movie.setId(7);
		movie.setMovieName("Sarkar");
		movie.setMovieComments("Biz Movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity mov=  movieEntityRepo.getOne(7);

		assertEquals(7,mov.getId());
	}
	
	@Test
	public void findMovieByNameTest() {	
		
		MovieEntity movie = new MovieEntity();
		movie.setId(4);
		movie.setMovieName("Gilli");
		movie.setMovieComments("Kabadi Movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity mov=  movieEntityRepo.getOne(4);
		assertEquals("Gilli",mov.getMovieName());
	}
	
	@Test
	public void getAllMovieTest() {
		MovieEntity movie= new MovieEntity();
		movie.setId(10);;
		movie.setMovieName("Mozhi");
		movie.setMovieComments("Radha great movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		
		MovieEntity movie2= new MovieEntity();
		movie2.setId(11);;
		movie2.setMovieName("alagu");
		movie2.setMovieComments("kumar great movie");
		movie2.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie2);

		final List<MovieEntity> movieEntList= movieEntityRepo.findAll();
		
	assertEquals(movieEntList.get(0).getId(),10);
	assertEquals(movieEntList.get(1).getMovieName(),"alagu");
	}
	

*/}