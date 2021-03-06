package br.com.vouviajar.dto;

import br.com.vouviajar.model.Company;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCompanyDTO{
   
	public UserCompanyDTO(String name, String phoneNumber, UserRegisterDTO user) {
		this.name = name;
		this.user = user;
		this.phoneNumber = phoneNumber;
	}

	@NotBlank(message="Name cannot be empty")
    private String name;
    
	@Valid
	@NotNull
	private UserRegisterDTO user;
  
	@NotBlank(message="Phone Number cannot be empty")
	private String phoneNumber;
        
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
	}
	
	public UserRegisterDTO getUser() {
		return user;
	}
	
	public void setUser(UserRegisterDTO user) {
		this.user = user;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static UserCompanyDTO toDTO(Company company){
		return new UserCompanyDTO(company.getName(), company.getPhoneNumber(), UserRegisterDTO.toDTO(company.getUser())); 
	}
	  
	public static UserCompanyDTO toDTO(Optional<Company> companyOptional){ 
		Company company = companyOptional.get(); 
		return new UserCompanyDTO(company.getName(), company.getPhoneNumber(), UserRegisterDTO.toDTO(company.getUser())); 
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