package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.vouviajar.vouviajarapirest.model.Person;

public class UserPersonDTO{
   
	public UserPersonDTO(String firstName, String lastName, String phoneNumber, UserDTO user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.phoneNumber = phoneNumber;
	}

	@NotBlank(message="First Name cannot be null")
    private String firstName;

	@NotBlank(message="Last Name cannot be null")
    private String lastName;
	
	@NotNull(message="User cannot be null")
	private UserDTO user;
  
	@NotBlank(message="Phone Number cannot be null")
	private String phoneNumber;
        
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;;
	}

	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static UserPersonDTO toDTO(Person person){ 
		return new UserPersonDTO(person.getFirstName(), person.getLastName(), person.getPhoneNumber(), UserDTO.toDTO(person.getUser())); 
	}
	  
	public static UserPersonDTO toDTO(Optional<Person> personOptional){ 
		Person person = personOptional.get(); 
		return new UserPersonDTO(person.getFirstName(), person.getLastName(), person.getPhoneNumber(), UserDTO.toDTO(person.getUser())); 
	}
	 
	public static List<UserPersonDTO> toDTO(List<Person> people){
		List<UserPersonDTO> usersPersonDTO = new ArrayList<UserPersonDTO>(); 
		for(Person person: people) 
			usersPersonDTO.add(toDTO(person)); 
		return usersPersonDTO; 
	}
	
	public Person toPerson(){
        return new Person(getFirstName(), getLastName(), getPhoneNumber(), getUser().toUser());
    }	
}