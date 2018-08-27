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
	private int movieCode;
	@Column(name="name")
	private String movieName;
	@Column(name="comment")
	private String movieComments;
	@Column(name="poster")
	private String posterPath;
	/**
	 * @return the movieCode
	 */
	public int getMovieCode() {
		return movieCode;
	}
	/**
	 * @param movieCode the movieCode to set
	 */
	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the movieComments
	 */
	public String getMovieComments() {
		return movieComments;
	}
	/**
	 * @param movieComments the movieComments to set
	 */
	public void setMovieComments(String movieComments) {
		this.movieComments = movieComments;
	}
	/**
	 * @return the posterPath
	 */
	public String getPosterPath() {
		return posterPath;
	}
	/**
	 * @param posterPath the posterPath to set
	 */
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	

}
