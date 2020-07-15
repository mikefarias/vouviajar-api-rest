package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.Company;
import br.com.vouviajar.vouviajarapirest.model.User;

public class UserDTO{

	public UserDTO() {
	}
	
	public UserDTO(String email) {
		this.email = email;
	}
    
	private String email;
        
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserDTO toDTO(User user){ 
		return new UserDTO(user.getEmail()); 
	}
	  
	public static UserDTO toDTO(Optional<User> userOptional){ 
		User user = userOptional.get(); 
		return new UserDTO(user.getEmail()); 
	} 

	public static List<UserDTO> toDTO(List<User> users, List<Company> companies){	  
		List<UserDTO> usersDTO = new ArrayList<UserDTO>(); 
		for(User user : users) 
			usersDTO.add(toDTO(user)); 
		return usersDTO; 
	}
	 
	public User toUser(){
        return new User( getEmail());
    }	
}