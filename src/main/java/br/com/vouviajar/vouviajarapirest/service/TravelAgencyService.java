package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.TravelAgencyAlreadyRegisteredException;
import br.com.vouviajar.vouviajarapirest.exception.TravelAgencyNotFoundException;
import br.com.vouviajar.vouviajarapirest.models.TravelAgency;
import br.com.vouviajar.vouviajarapirest.repository.TravelAgencyRepository;

@Service
public class TravelAgencyService{
    
    private TravelAgencyRepository travelAgencyRepository; 

    @Autowired
    public TravelAgencyService(TravelAgencyRepository travelAgencyRepository){
        this.travelAgencyRepository = travelAgencyRepository;
    }

    public Optional<TravelAgency> getById(Long id) {
    	
    	return travelAgencyRepository.findById(id);
    }

    public List<TravelAgency> getAll() {
    	
    	return travelAgencyRepository.findAll();
    }
    
    public TravelAgency create(TravelAgency travelAgency){
        
    	if(travelAgency.getCodeCadastur() == null || travelAgency.getCodeCadastur() == "" ){
    		throw new InvalidDataException();
    	}
    	  
    	
        if(travelAgencyRepository.findByCodeCadastur(travelAgency.getCodeCadastur()) != null) {
        	throw new TravelAgencyAlreadyRegisteredException();
        }            
        
        return createTravelAgency(travelAgency);
    }

    private TravelAgency createTravelAgency(TravelAgency travelAgency) {
    	
    	travelAgency.setActive(true);
    	travelAgency.setCreatedOn(OffsetDateTime.now());
    	travelAgency.setModifiedOn(OffsetDateTime.now());
    	return travelAgencyRepository.save(travelAgency);
    }
    
    public TravelAgency update(TravelAgency travelAgency, Long id) {
    	
    	if(travelAgency.getCodeCadastur() == null || travelAgency.getCodeCadastur() == "" ){
    		throw new InvalidDataException();
    	}
    	  
    	Optional<TravelAgency> travelAgency_db = travelAgencyRepository.findById(id);;
    	if( travelAgency_db == null) {
    		throw new TravelAgencyNotFoundException(); 
    	}
    	
    	return updateTravelAgency(travelAgency, travelAgency_db.get());
    }
    
    private TravelAgency updateTravelAgency(TravelAgency travelAgency, TravelAgency travelAgency_db) {
    	
    	travelAgency_db.setCodeCadastur(travelAgency.getCodeCadastur());
    	travelAgency_db.setIsPhysicalAgency(travelAgency.getIsPhysicalAgency());
    	travelAgency_db.setModifiedOn(OffsetDateTime.now());
    	
    	return travelAgencyRepository.save(travelAgency_db);
    }
    
    public void delete(Long id) {
    	
    	Optional<TravelAgency> travelAgency_db = travelAgencyRepository.findById(id);;
    	if( travelAgency_db == null) {
    		throw new TravelAgencyNotFoundException(); 
    	}
    	TravelAgency travelAgency = travelAgency_db.get();
    	travelAgency.setActive(false);
    	travelAgencyRepository.save(travelAgency);
    	
    }
}
