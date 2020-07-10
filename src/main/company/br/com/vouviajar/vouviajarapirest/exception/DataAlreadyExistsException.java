package br.com.vouviajar.vouviajarapirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class DataAlreadyExistsException extends RuntimeException{
	
	public DataAlreadyExistsException(String message) {
		super(message);
	}
	
	private static final long serialVersionUID = 1L;

}