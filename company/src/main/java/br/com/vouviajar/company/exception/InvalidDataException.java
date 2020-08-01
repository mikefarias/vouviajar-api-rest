package br.com.vouviajar.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidDataException extends RuntimeException{

	public InvalidDataException(String message) {
		super(message);
	}
	
	private static final long serialVersionUID = 1L;

}