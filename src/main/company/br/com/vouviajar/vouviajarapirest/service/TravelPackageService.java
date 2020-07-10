package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.exception.TravelpackageAlreadyRegisteredException;
import br.com.vouviajar.vouviajarapirest.model.TravelPackage;
import br.com.vouviajar.vouviajarapirest.repository.TravelPackageRepository;

@Service
public class TravelPackageService{
    
    private TravelPackageRepository travelPackageRepository; 

    @Autowired
    public TravelPackageService(TravelPackageRepository travelPackageRepository){
        this.travelPackageRepository = travelPackageRepository;
    }

    public Optional<TravelPackage> getById(Long id) {
    	
    	return travelPackageRepository.findById(id);
    }

    public List<TravelPackage> getAll() {
    	
    	return travelPackageRepository.findAll();
    }
    
    public TravelPackage create(TravelPackage travelPackage){
        

    	if(travelPackage.getName() == null || travelPackage.getName() == "" ){ 
    		throw new InvalidDataException(); 
    	}
		  
    	if(travelPackageRepository.findByName(travelPackage.getName()) != null) { 
    		throw new TravelpackageAlreadyRegisteredException(); 
    	}
		        
        return createTravelPackage(travelPackage);
    }

    private TravelPackage createTravelPackage(TravelPackage travelPackage) {
    	
    	travelPackage.setActive(true);
    	travelPackage.setCreatedOn(OffsetDateTime.now());
    	travelPackage.setModifiedOn(OffsetDateTime.now());
    	return travelPackageRepository.save(travelPackage);
    }
    
    public TravelPackage update(TravelPackage travelPackage, Long id) {
    	
		
		if(travelPackage.getName() == null || travelPackage.getName() == "" ){ 
			throw new InvalidDataException();
		}
		
    	  
    	Optional<TravelPackage> travelPackage_db = travelPackageRepository.findById(id);;
    	if( travelPackage_db == null) {
    		throw new NotFoundException("Travel Package not found"); 
    	}
    	
    	return updateTravelPackage(travelPackage, travelPackage_db.get());
    }
    
    private TravelPackage updateTravelPackage(TravelPackage travelPackage, TravelPackage travelPackage_db) {
    	
		
		travelPackage_db.setName(travelPackage.getName());
		travelPackage_db.setInvestiment(travelPackage.getInvestiment());
		 
    	travelPackage_db.setModifiedOn(OffsetDateTime.now());
    	
    	return travelPackageRepository.save(travelPackage_db);
    }
    
    public void delete(Long id) {
    	
    	Optional<TravelPackage> travelPackage_db = travelPackageRepository.findById(id);;
    	if( travelPackage_db == null) {
    		throw new NotFoundException("Travel Package not found"); 
    	}
    	TravelPackage travelPackage = travelPackage_db.get();
    	travelPackage.setActive(false);
    	travelPackageRepository.save(travelPackage);
    	
    }
}