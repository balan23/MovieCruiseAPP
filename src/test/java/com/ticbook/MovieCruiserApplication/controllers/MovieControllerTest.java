/**
 * 
 */
package com.ticbook.MovieCruiserApplication.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticbook.MovieCruiserApplication.entities.MovieEntity;
import com.ticbook.MovieCruiserApplication.exceptions.MovieAlreadyExistsException;
import com.ticbook.MovieCruiserApplication.exceptions.MovieNotFoundException;
import com.ticbook.MovieCruiserApplication.services.MovieService;

/**
 * @author Manobalan A
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MovieService movieService;
	private List<MovieEntity> movieList;
	@Before
	public void initiaModel() {
		movieList = new ArrayList<MovieEntity>();
		MovieEntity movie1 = new MovieEntity();
		movie1.setMovieCode(1);
		movie1.setMovieName("Athiharam1");
		movie1.setMovieComments("Tells to save the nation for bettermanet");
		movie1.setPosterPath("https://www.imdb.com/title/tt4779682/mediaviewer/rm1110263296");
		movieList.add(movie1);
		MovieEntity movie2 = new MovieEntity();
		movie2.setMovieCode(2);
		movie2.setMovieName("Dragon walls");
		movie2.setMovieComments("good entertainmaint with pakka comedy.");
		movie2.setPosterPath("https://www.imdb.com/title/tt5220122/mediaviewer/rm1546076160");
		movieList.add(movie2);
	}
	@Test
	public void testGetMovieDetails() throws Exception {
		when(movieService.getMovieById(1)).thenReturn(movieList.get(0));
		mockMvc.perform(get("/movies/{id}",1)).andExpect(status().isOk());
		verify(movieService, times(1)).getMovieById(1);
		verifyNoMoreInteractions(movieService);	
	}
	@Test
	public void testGetMovieDetailsException() throws Exception {
		when(movieService.getMovieById(2)).thenThrow(new MovieNotFoundException("Movie not found exception"));
		mockMvc.perform(get("/movies/{id}",2)).andExpect(status().isConflict());
		verify(movieService, times(1)).getMovieById(2);
		verifyNoMoreInteractions(movieService);	
	}
	@Test
	public void testGetAllMovies() throws Exception {
		when(movieService.getAllMovies()).thenReturn(movieList);
		mockMvc.perform(get("/movies/all")).andExpect(status().isOk());
		verify(movieService, times(1)).getAllMovies();
		verifyNoMoreInteractions(movieService);	
	}
	
	@Test
	public void testDeleteById() throws Exception {
		when(movieService.deleteMovieById(1)).thenReturn(true);
		mockMvc.perform(post("/movies/delete/{id}",1)).andExpect(status().isOk());
		verify(movieService, times(1)).deleteMovieById(1);
		verifyNoMoreInteractions(movieService);	
	}
	
	@Test
	public void testDeleteByIdExeption() throws Exception {
		when(movieService.deleteMovieById(1)).thenThrow(new MovieNotFoundException("Movie not found exception"));
		mockMvc.perform(post("/movies/delete/{id}",1)).andExpect(status().isConflict());
		verify(movieService, times(1)).deleteMovieById(1);
		verifyNoMoreInteractions(movieService);	
	}
	
	@Test
	public void testsaveMovie() throws Exception {
		when(movieService.saveMovie(movieList.get(0))).thenReturn(true);
		mockMvc.perform(post("/movies/save").contentType(MediaType.APPLICATION_JSON).content(daoToJson(movieList.get(0)))).andExpect(status().isCreated());
		verify(movieService, times(1)).saveMovie(Mockito.any(MovieEntity.class));
		verifyNoMoreInteractions(movieService);	
	}
	
	
	@Test
	public void testUpdateMovie() throws Exception {
		when(movieService.updateMovie(movieList.get(0))).thenReturn(movieList.get(0));
		mockMvc.perform(put("/movies/update").contentType(MediaType.APPLICATION_JSON).content(daoToJson(movieList.get(0)))).andExpect(status().isOk());
		verify(movieService, times(1)).updateMovie(Mockito.any(MovieEntity.class));
		verifyNoMoreInteractions(movieService);	
	}
	
	
	private String daoToJson(MovieEntity movieEntity) {
		ObjectMapper  objMapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = objMapper.writeValueAsString(movieEntity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}


}
