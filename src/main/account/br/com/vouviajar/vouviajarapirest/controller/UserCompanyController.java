package br.com.vouviajar.vouviajarapirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajarapirest.dto.UserCompanyDTO;
import br.com.vouviajar.vouviajarapirest.model.Company;
import br.com.vouviajar.vouviajarapirest.service.UserCompanyService;

@RestController
@RequestMapping("/api/v1")
public class UserCompanyController {

	private UserCompanyService userCompanyService;

	@Autowired
	public UserCompanyController(UserCompanyService userCompanyService) {
		this.userCompanyService = userCompanyService;
	}

	
	@RequestMapping(value = "/user/company/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserCompanyDTO> getById(@PathVariable Long id ){
		Optional<Company> company = userCompanyService.getById(id); 
		if(company.isEmpty())
			return new ResponseEntity<UserCompanyDTO>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<UserCompanyDTO>(UserCompanyDTO.toDTO(company), HttpStatus.OK); }
	  
	@RequestMapping(value = "/user/company", method = RequestMethod.GET) 
	public ResponseEntity<List<UserCompanyDTO>> getAll(){ 
		List<Company> companies = userCompanyService.getAll(); 
		if(companies.isEmpty()) 
			return new ResponseEntity<List<UserCompanyDTO>>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<List<UserCompanyDTO>>(UserCompanyDTO.toDTO(companies), HttpStatus.OK); 
	}
	    
	@RequestMapping(value = "/user/company", method = RequestMethod.POST)
	public ResponseEntity<UserCompanyDTO> register(@RequestBody UserCompanyDTO userCompanyDTO) {
		Company company = userCompanyService.registerUserCompany(userCompanyDTO.toCompany());
		return new ResponseEntity<UserCompanyDTO>(UserCompanyDTO.toDTO(company), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/company/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserCompanyDTO> update(@RequestBody UserCompanyDTO userCompanyDTO, @PathVariable Long id ){ 
		Company company = userCompanyService.update(userCompanyDTO.toCompany(), id); 
		return new ResponseEntity<UserCompanyDTO>(UserCompanyDTO.toDTO(company), HttpStatus.OK); 
	}
	  
	@RequestMapping(value = "/user/company/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserCompanyDTO> delete(@PathVariable Long id ){
		userCompanyService.delete(id); 
		return new ResponseEntity<>( HttpStatus.OK); 
	}
	 
}