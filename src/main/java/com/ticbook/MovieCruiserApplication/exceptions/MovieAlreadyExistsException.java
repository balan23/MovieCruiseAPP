/**
 * 
 */
package com.ticbook.MovieCruiserApplication.exceptions;

/**
 * @author Manobalan A
 *
 */
@SuppressWarnings("serial")
public class MovieAlreadyExistsException extends Exception {
	
	public MovieAlreadyExistsException(final String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	private String errorMessage;

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
