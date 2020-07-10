package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.DataAlreadyExistsException;
import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.TravelContract;
import br.com.vouviajar.vouviajarapirest.repository.TravelContractRepository;

@Service
public class TravelContractService{
    
    private TravelContractRepository travelContractRepository; 

    @Autowired
    public TravelContractService(TravelContractRepository travelContractRepository){
        this.travelContractRepository = travelContractRepository;
    }

    public Optional<TravelContract> getById(Long id) {
    	
    	return travelContractRepository.findById(id);
    }

    public List<TravelContract> getAll() {
    	
    	return travelContractRepository.findAll();
    }
    
    public TravelContract create(TravelContract travelContract){
        

    	if(travelContract.getTerms() == null || travelContract.getTerms() == "" ){ 
    		throw new InvalidDataException(); 
    	}
		  
    	if(travelContractRepository.findByTerms(travelContract.getTerms()) != null) { 
    		throw new DataAlreadyExistsException("Travel Contract already exists"); 
    	}
		        
        return createTravelContract(travelContract);
    }

    private TravelContract createTravelContract(TravelContract travelContract) {
    	
    	travelContract.setActive(true);
    	travelContract.setCreatedOn(OffsetDateTime.now());
    	travelContract.setModifiedOn(OffsetDateTime.now());
    	return travelContractRepository.save(travelContract);
    }
    
    public TravelContract update(TravelContract travelContract, Long id) {
    	
		
		if(travelContract.getTerms() == null || travelContract.getTerms() == "" ){ 
			throw new InvalidDataException();
		}
		
    	  
    	Optional<TravelContract> travelContract_db = travelContractRepository.findById(id);;
    	if( travelContract_db == null) {
    		throw new NotFoundException("Travel Contract not found"); 
    	}
    	
    	return updateTravelContract(travelContract, travelContract_db.get());
    }
    
    private TravelContract updateTravelContract(TravelContract travelContract, TravelContract travelContract_db) {
    	
		
		travelContract_db.setTerms(travelContract.getTerms());
		 
    	travelContract_db.setModifiedOn(OffsetDateTime.now());
    	
    	return travelContractRepository.save(travelContract_db);
    }
    
    public void delete(Long id) {
    	
    	Optional<TravelContract> travelContract_db = travelContractRepository.findById(id);;
    	if( travelContract_db == null) {
    		throw new NotFoundException("Travel Contract not found"); 
    	}
    	TravelContract travelContract = travelContract_db.get();
    	travelContract.setActive(false);
    	travelContractRepository.save(travelContract);
    	
    }
}
