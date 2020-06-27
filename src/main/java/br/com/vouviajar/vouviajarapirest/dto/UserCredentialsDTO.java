package br.com.vouviajar.vouviajarapirest.dto;

import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.models.User;

public class UserCredentialsDTO{
   
	public UserCredentialsDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	private String email;
    
    private String password;
        
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static UserCredentialsDTO toDTO(User user){
        return new UserCredentialsDTO(user.getEmail(), user.getPassword());
    }
	
	public static UserCredentialsDTO toDTO(Optional<User> userOptional){
		User user = userOptional.get();
        return new UserCredentialsDTO(user.getEmail(), user.getPassword());
    }
	
	public User toUser(){
        return new User( getEmail(), getPassword());
    }
	
}