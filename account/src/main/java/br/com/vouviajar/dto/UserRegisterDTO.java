package br.com.vouviajar.dto;

import br.com.vouviajar.model.Company;
import br.com.vouviajar.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRegisterDTO{

	public UserRegisterDTO() {
	}
	
	public UserRegisterDTO(String email) {
		this.email = email;
	}
    
	@NotBlank
	@Email
	private String email;
        
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserRegisterDTO toDTO(User user){
		return new UserRegisterDTO(user.getEmail()); 
	}
	  
	public static UserRegisterDTO toDTO(Optional<User> userOptional){ 
		User user = userOptional.get(); 
		return new UserRegisterDTO(user.getEmail()); 
	} 

	public static List<UserRegisterDTO> toDTO(List<User> users, List<Company> companies){
		List<UserRegisterDTO> usersDTO = new ArrayList<UserRegisterDTO>(); 
		for(User user : users) 
			usersDTO.add(toDTO(user)); 
		return usersDTO; 
	}
	 
	public User toUser(){
        return new User( getEmail());
    }	
}