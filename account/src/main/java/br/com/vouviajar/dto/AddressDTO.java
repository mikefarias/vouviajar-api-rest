package br.com.vouviajar.dto;

import br.com.vouviajar.model.Address;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDTO{
   
	public AddressDTO(String address, String address2, String district, String city, String state, String country,
			String postalCode) {
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	@NotBlank(message="Address cannot be empty")
	private String address;
	
	@NotBlank(message="Address2 cannot be empty")
	private String address2;
	
	@NotBlank(message="District cannot be empty")
	private String district;
	
	@NotBlank(message="City cannot be empty")
	private String city;
	
	@NotBlank(message="State cannot be empty")
	private String state;
	
	@NotBlank(message="Country cannot be empty")
	private String country;
	
	@NotBlank(message="Postal Code cannot be empty")
	private String postalCode;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public static AddressDTO toDTO(Address address){
		return new AddressDTO(address.getAddress(), address.getAddress2(), address.getDistrict(), address.getCity(), address.getState(), address.getCountry(), address.getPostalCode()); 
	}
	  
	public static AddressDTO toDTO(Optional<Address> addressOptional){ 
		Address address = addressOptional.get(); 
		return new AddressDTO(address.getAddress(), address.getAddress2(), address.getDistrict(), address.getCity(), address.getState(), address.getCountry(), address.getPostalCode()); 
	}
	 
	public static List<AddressDTO> toDTO(List<Address> companies){
		List<AddressDTO> usersAddressDTO = new ArrayList<AddressDTO>(); 
		for(Address address: companies) 
			usersAddressDTO.add(toDTO(address)); 
		return usersAddressDTO; 
	}
	
	public Address toAddress(){
        return new Address(getAddress(), getAddress2(), getDistrict(), getCity(), getState(), getCountry(), getPostalCode());
    }	
}