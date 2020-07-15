package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.exception.UninformedCredentialsException;
import br.com.vouviajar.vouviajarapirest.exception.UserAlreadyRegisteredException;
import br.com.vouviajar.vouviajarapirest.model.Company;
import br.com.vouviajar.vouviajarapirest.model.User;
import br.com.vouviajar.vouviajarapirest.repository.UserCompanyRepository;
import br.com.vouviajar.vouviajarapirest.repository.UserPersonRepository;
import br.com.vouviajar.vouviajarapirest.repository.UserRepository;

@Service
public class UserCompanyService{
    
    private UserCompanyRepository userCompanyRepository; 
    private UserRepository userRepository; 
    
    @Autowired
    public UserCompanyService(UserCompanyRepository userCompanyRepository, UserRepository userRepository){
        this.userCompanyRepository = userCompanyRepository;
        this.userRepository = userRepository;
    }

    public Optional<Company> getById(Long id) {	
    	return userCompanyRepository.findById(id);
    }

    public List<Company> getAll() {    	
    	return userCompanyRepository.findAll();
    }
    
    public Company register(Company company){
    	validateData(company);    	  
        if(userCompanyRepository.findByName(company.getName()) != null)
        	throw new UserAlreadyRegisteredException();            
        return registerCompany(company);
    }

    private Company registerCompany(Company company) {    		
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
    	return userCompanyRepository.saveAndFlush(company);
    }
    
    public Company update(Company company, Long id) {    	
    	validateData(company);    	  
    	Company companyDB = verifyIfUserExists(id);    	
    	return updateCompany(company, companyDB);
    }
    
    private Company updateCompany(Company company, Company companyDB) {
    	companyDB.setName(company.getName());
    	companyDB.setPhoneNumber(company.getPhoneNumber());
    	companyDB.setModifiedOn(OffsetDateTime.now());
    	return userCompanyRepository.save(companyDB);
    }
    
    public void delete(Long id) {    	
    	Company company = verifyIfUserExists(id);
    	company.setActive(false);
    	company.setModifiedOn(OffsetDateTime.now());
    	company.getUser().setActive(false);
    	company.getUser().setModifiedOn(OffsetDateTime.now());
    	userCompanyRepository.save(company);    	
    }
	
	private Company verifyIfUserExists(Long id) { 
		Optional<Company> userDB = userCompanyRepository.findById(id); 
		if( userDB == null) 
			throw new NotFoundException("User not found"); 
		return userDB.get(); 
	}
	  
	private void validateData(Company company) { 
		if(company.getName() == null || company.getPhoneNumber()==null 
				|| company.getName() == "" || company.getPhoneNumber() ==  "") 
			throw new UninformedCredentialsException(); 
	}
}