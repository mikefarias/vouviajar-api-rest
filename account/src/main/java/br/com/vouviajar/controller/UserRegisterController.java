package br.com.vouviajar.controller;

import br.com.vouviajar.dto.UserCompanyDTO;
import br.com.vouviajar.dto.UserPersonDTO;
import br.com.vouviajar.model.Company;
import br.com.vouviajar.model.Person;
import br.com.vouviajar.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserRegisterController {

	private UserRegisterService userRegisterService;

	@Autowired
	public UserRegisterController(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}

	@RequestMapping(value = "/register/user/company", method = RequestMethod.POST)
	public ResponseEntity<UserCompanyDTO> registerUser(@RequestBody @Valid UserCompanyDTO userCompanyDTO) {
		Company company = userRegisterService.registerUserCompany(userCompanyDTO.toCompany());
		return new ResponseEntity<UserCompanyDTO>(UserCompanyDTO.toDTO(company), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/register/user/person", method = RequestMethod.POST)
	public ResponseEntity<UserPersonDTO> registerUser(@RequestBody @Valid UserPersonDTO userPersonDTO) {
		Person person = userRegisterService.registerUserPerson(userPersonDTO.toPerson());
		return new ResponseEntity<UserPersonDTO>(UserPersonDTO.toDTO(person), HttpStatus.CREATED);
	}
}