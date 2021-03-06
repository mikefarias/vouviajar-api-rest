package br.com.vouviajar.service;

import br.com.vouviajar.exception.NotFoundException;
import br.com.vouviajar.model.Company;
import br.com.vouviajar.repository.AddressRepository;
import br.com.vouviajar.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class CompanyService{
    
    private CompanyRepository companyRepository;
    private AddressRepository addressRepository;
    
    @Autowired
    public CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository){
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

    public Optional<Company> getById(Long id) {	
    	return companyRepository.findById(id);
    }
    
    public Company update(Company company, Long id) {    	
    	Company companyDB = verifyIfUserExists(id);
    	return updateCompany(company, companyDB);
    }
    
    private Company updateCompany(Company company, Company companyDB) {
    	companyDB.setName(company.getName());
    	companyDB.setPhoneNumber(company.getPhoneNumber());
    	companyDB.setCnpj(company.getCnpj());
    	companyDB.setModifiedOn(OffsetDateTime.now());
    	addressRepository.save(company.getAddress());
    	companyDB.setAddress(company.getAddress());
    	return companyRepository.saveAndFlush(companyDB);
    }
    
    public void delete(Long id) {    	
    	Company company = verifyIfUserExists(id);
    	company.setActive(false);
    	company.setModifiedOn(OffsetDateTime.now());
    	companyRepository.save(company);    	
    }
	
	private Company verifyIfUserExists(Long id) { 
		Optional<Company> companyDB = companyRepository.findById(id); 
		if( companyDB == null) 
			throw new NotFoundException("Company not found");
		return companyDB.get(); 
	}
}