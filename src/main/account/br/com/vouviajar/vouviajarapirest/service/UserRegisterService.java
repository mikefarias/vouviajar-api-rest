package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.model.Company;
import br.com.vouviajar.vouviajarapirest.model.Person;
import br.com.vouviajar.vouviajarapirest.model.User;
import br.com.vouviajar.vouviajarapirest.repository.CompanyRepository;
import br.com.vouviajar.vouviajarapirest.repository.PersonRepository;
import br.com.vouviajar.vouviajarapirest.repository.UserRepository;

@Service
public class UserRegisterService{
    
    private CompanyRepository companyRepository; 
    private PersonRepository personRepository;
    private UserRepository userRepository;
    
    @Autowired
    public UserRegisterService(CompanyRepository companyRepository, PersonRepository personRepository, UserRepository userRepository){
        this.companyRepository = companyRepository;
        this.personRepository = personRepository;
        this.userRepository = userRepository;
    }

    public Company registerUserCompany(Company company){      
        return createUserCompany(company);
    }

    private Company createUserCompany(Company company) {    		
    	company.setActive(true);
    	company.setCreatedOn(OffsetDateTime.now());
    	company.setModifiedOn(OffsetDateTime.now());
    	User user = company.getUser();
    	user.setActive(true);
    	user.setCreatedOn(OffsetDateTime.now());
    	user.setModifiedOn(OffsetDateTime.now());
    	user.setEnable(false);
    	user.setStaff(true);
    	userRepository.save(user);
    	return companyRepository.saveAndFlush(company);
    }
    
    public Person registerUserPerson(Person person){            
        return createUserPerson(person);
    }

    private Person createUserPerson(Person person) {    		
    	person.setActive(true);
    	person.setCreatedOn(OffsetDateTime.now());
    	person.setModifiedOn(OffsetDateTime.now());
    	User user = person.getUser();
    	user.setActive(true);
    	user.setCreatedOn(OffsetDateTime.now());
    	user.setModifiedOn(OffsetDateTime.now());
    	user.setEnable(false);
    	user.setStaff(false);
    	userRepository.save(user);
    	return personRepository.saveAndFlush(person);
    }
}