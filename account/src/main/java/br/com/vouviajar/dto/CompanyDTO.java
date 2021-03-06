package br.com.vouviajar.dto;

import br.com.vouviajar.model.Company;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CompanyDTO{
   
	public CompanyDTO(String name, String phoneNumber, String cnpj, AddressDTO address ) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.cnpj = cnpj;
		this.address = address;
	}

	@NotBlank(message="Name cannot be null")
    private String name;
  
	@NotBlank(message="Phone Number cannot be null")
	private String phoneNumber;
        
	@NotBlank(message="CNPJ cannot be null")
	private String cnpj;

	@Valid
	@NotNull(message="Address cannot be null")
	private  AddressDTO address;

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public AddressDTO getAddress() {
		return address;
	}
	
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	
	public static CompanyDTO toDTO(Company company){
		return new CompanyDTO(company.getName(), company.getPhoneNumber(), company.getCnpj(), AddressDTO.toDTO(company.getAddress())); 
	}
	  
	public static CompanyDTO toDTO(Optional<Company> companyOptional){ 
		Company company = companyOptional.get(); 
		return new CompanyDTO(company.getName(), company.getPhoneNumber(), company.getCnpj(), AddressDTO.toDTO(company.getAddress())); 
	}

	public Company toCompany(){
        return new Company(getName(), getPhoneNumber(), getCnpj(), getAddress().toAddress());
    }	
}