package com.ticbook.MovieCruiserAuthentication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@Column(name = "userId", length=50)
	private String userId;
	@Column(name = "firstName", length=50)
	private String firstName;
	@Column(name = "lastName", length=50)
	private String lastName;
	@Column(name = "password", length=50)
	private String password;
		
	@CreationTimestamp
	@Column(name = "created")
	private Date created;

	
	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param created
	 */
	public User(String userId, String firstName, String lastName, String password, Date created) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.created = created;
	}


	/**
	 * 
	 */
	public User() {
		super();
	}


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}


	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}	
}
