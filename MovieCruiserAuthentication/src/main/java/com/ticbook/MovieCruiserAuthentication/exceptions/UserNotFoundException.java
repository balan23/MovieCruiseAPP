package com.ticbook.MovieCruiserAuthentication.exceptions;


@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}