package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.vouviajar.vouviajarapirest.model.Company;

public class UserCompanyDTO{
   
	public UserCompanyDTO(String name, String phoneNumber, UserDTO user) {
		this.name = name;
		this.user = user;
		this.phoneNumber = phoneNumber;
	}

	@NotBlank(message="Name cannot be null")
    private String name;
    
	@NotNull
	private UserDTO user;
  
	@NotBlank(message="Phone Number cannot be null")
	private String phoneNumber;
        
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
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
	
	public static UserCompanyDTO toDTO(Company company){ 
		return new UserCompanyDTO(company.getName(), company.getPhoneNumber(), UserDTO.toDTO(company.getUser())); 
	}
	  
	public static UserCompanyDTO toDTO(Optional<Company> companyOptional){ 
		Company company = companyOptional.get(); 
		return new UserCompanyDTO(company.getName(), company.getPhoneNumber(), UserDTO.toDTO(company.getUser())); 
	}
	 
	public static List<UserCompanyDTO> toDTO(List<Company> companies){
		List<UserCompanyDTO> usersCompanyDTO = new ArrayList<UserCompanyDTO>(); 
		for(Company company: companies) 
			usersCompanyDTO.add(toDTO(company)); 
		return usersCompanyDTO; 
	}
	
	public Company toCompany(){
        return new Company(getName(), getPhoneNumber(), getUser().toUser());
    }	
}