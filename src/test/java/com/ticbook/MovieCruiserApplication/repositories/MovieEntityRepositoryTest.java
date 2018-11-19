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
@RunWith(SpringRunner.class)
//@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieEntityRepositoryTest{
	
	@Autowired
	private transient MovieEntityRepository movieEntityRepo;

	
public void setRepo(final MovieEntityRepository movieEntityRepo) {
	this.movieEntityRepo= movieEntityRepo;
}
	
	@Test
	public void saveMovieTest() throws Exception {
		final MovieEntity mov = addMovie();
		assertThat(mov.getId()).isEqualTo(1);
	}

	/**
	 * @return
	 */
	private MovieEntity addMovie() {
		MovieEntity movie = new MovieEntity();
		movie.setId(1);
		movie.setMovieName("seemaraja");
		movie.setMovieComments("Siva's great movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		final MovieEntity mov=  movieEntityRepo.getOne(1);
		return mov;
	}
	
	@Test
	public void updateMovieTest() throws Exception {

		final MovieEntity uMov=  addMovie();
		assertEquals(uMov.getMovieName(),"seemaraja");
		uMov.setMovieComments("Rated 4.0");
		movieEntityRepo.save(uMov);
		final MovieEntity mov=  movieEntityRepo.getOne(1);
		assertEquals(mov.getMovieComments(),"Rated 4.0");
	}	

	
	@Test
	public void deleteMovieByIdTest() {
		
		final MovieEntity mov=  addMovie();
		assertEquals("seemaraja", mov.getMovieName());
		movieEntityRepo.delete(mov);
		assertEquals(Optional.empty(),movieEntityRepo.findById(1));

	}
	
	@Test
	public void findMovieByIdTest() {		
		
		final MovieEntity mov = addMovie();

		assertEquals(1,mov.getId());
	}
	
	@Test
	public void findMovieByNameTest() {	
		
		final MovieEntity mov = addMovie();
		assertEquals("seemaraja",mov.getMovieName());
	}
	
	@Test
	public void getAllMovieTest() {
		MovieEntity movie= new MovieEntity();
		movie.setId(1);;
		movie.setMovieName("seemaraja");
		movie.setMovieComments("Siva's great movie");
		movie.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie);
		
		MovieEntity movie2= new MovieEntity();
		movie2.setId(2);;
		movie2.setMovieName("alagu");
		movie2.setMovieComments("Siva's great movie");
		movie2.setPosterPath("www.glitz.com");
		movieEntityRepo.save(movie2);

		final List<MovieEntity> movieEntList= movieEntityRepo.findAll();
		
	assertEquals(movieEntList.get(0).getId(),1);
	assertEquals(movieEntList.get(1).getMovieName(),"alagu");
	}
	

}