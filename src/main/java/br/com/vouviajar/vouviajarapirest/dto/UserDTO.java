package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.models.User;

public class UserDTO{
   
	public UserDTO(String email, String password) {
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

	public static UserDTO toDTO(User user){
        return new UserDTO(user.getEmail(), user.getPassword());
    }
	
	public static UserDTO toDTO(Optional<User> userOptional){
		User user = userOptional.get();
        return new UserDTO(user.getEmail(), user.getPassword());
    }

	public static List<UserDTO> toDTO(List<User> users){
		
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		
		for(User user : users) {
			usersDTO.add(toDTO(user));
		}
        return usersDTO;
    }

	public User toUser(){
        return new User( getEmail(), getPassword());
    }
	
}