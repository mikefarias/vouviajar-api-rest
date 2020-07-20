package br.com.vouviajar.vouviajarapirest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajarapirest.dto.CompanyDTO;
import br.com.vouviajar.vouviajarapirest.model.Company;
import br.com.vouviajar.vouviajarapirest.service.CompanyService;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

	private CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public ResponseEntity<CompanyDTO> getById(@PathVariable Long id ){
		Optional<Company> company = companyService.getById(id); 
		if(company.isEmpty())
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<CompanyDTO>(CompanyDTO.toDTO(company), HttpStatus.OK); 
	}
	    
	@RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO, @PathVariable Long id ){ 
		Company company = companyService.update(companyDTO.toCompany(), id); 
		return new ResponseEntity<CompanyDTO>(CompanyDTO.toDTO(company), HttpStatus.OK); 
	}
	  
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CompanyDTO> delete(@PathVariable Long id ){
		companyService.delete(id); 
		return new ResponseEntity<>( HttpStatus.OK); 
	} 
}