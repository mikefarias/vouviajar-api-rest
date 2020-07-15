package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.Company;

public class UserCompanyDTO{
   
	public UserCompanyDTO(String name, String phoneNumber, UserDTO userDTO) {
		this.name = name;
		this.userDTO = userDTO;
		this.phoneNumber = phoneNumber;
	}

    private String name;
    
	private UserDTO userDTO;
  
	private String phoneNumber;
        
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
	}
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	
	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
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
        return new Company(getName(), getPhoneNumber(), getUserDTO().toUser());
    }	
}