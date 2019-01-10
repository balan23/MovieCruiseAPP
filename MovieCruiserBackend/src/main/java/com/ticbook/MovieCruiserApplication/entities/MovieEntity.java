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
import javax.validation.constraints.Size;

/**
 * @author Manobalan
 *
 */
@Entity
@Table(name ="movie")
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private int id;
	
	@Column(name="movieId")
	private String movieId;
	

	@Column(name="name", length=50)
	private String title;
	
	@Column(name="comment", length=3000)
	@Size(max=3000)	
	private String overview;
	
	@Column(name="poster", length=200)
	private String poster_path;
	
	@Column(name= "release_date", length=200)
	private String release_date;
	
	@Column(name= "userId")
	private String userId;
	
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
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
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
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
