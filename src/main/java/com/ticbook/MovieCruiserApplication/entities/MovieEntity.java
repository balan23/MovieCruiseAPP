/**
 * 
 */
package com.ticbook.MovieCruiserApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manobalan
 *
 */
@Entity
@Table(name ="movie")
public class MovieEntity {
	
	@Id
	@Column(name="id")
	private int id;
	

/*	@Column(name="movieCode")
	private int movieCode;*/
	
	@Column(name="name")
	private String title;
	@Column(name="comment")
	private String overview;
	@Column(name="poster")
	private String poster_path;
	/**
	 * @return the movieCode
	 */
/*	public int getMovieCode() {
		return movieCode;
	}*/
	/**
	 * @param movieCode the movieCode to set
	 */
/*	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getMovieName() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setMovieName(String title) {
		this.title = title;
	}
	/**
	 * @return the movieComments
	 */
	public String getMovieComments() {
		return overview;
	}
	/**
	 * @param movieComments the movieComments to set
	 */
	public void setMovieComments(String movieComments) {
		this.overview = movieComments;
	}
	/**
	 * @return the posterPath
	 */
	public String getPosterPath() {
		return poster_path;
	}
	/**
	 * @param posterPath the posterPath to set
	 */
	public void setPosterPath(String posterPath) {
		this.poster_path = posterPath;
	}
	
	

}
