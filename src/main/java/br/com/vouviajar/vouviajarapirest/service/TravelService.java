package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.Travel;
import br.com.vouviajar.vouviajarapirest.repository.TravelRepository;

@Service
public class TravelService{
    
    private TravelRepository travelRepository; 

    @Autowired
    public TravelService(TravelRepository travelRepository){
        this.travelRepository = travelRepository;
    }

    public Optional<Travel> getById(Long id) {

    	verifyIfTravelExists(id);
    	return travelRepository.findById(id);
    }

    public List<Travel> getAll() {
    	
    	return travelRepository.findAll();
    }
    
    public Travel create(Travel travel){
        
    	validateData(travel);
        return createTravel(travel);
    }

    private Travel createTravel(Travel travel) {
    
    	//Setar usuário que está realizando o cadastro
    	travel.setIdTravelAgency(travel.getIdTravelAgency());
    	travel.setActive(true);
    	travel.setCreatedOn(OffsetDateTime.now());
    	travel.setModifiedOn(OffsetDateTime.now());
    	return travelRepository.save(travel);
    }
    
    public Travel update(Travel travel, Long id) {
    	
    	verifyIfTravelExists(id);
    	validateData(travel);
    	Optional<Travel> travel_db = travelRepository.findById(id);
    	return updateTravel(travel, travel_db.get());
    }
    
    private Travel updateTravel(Travel travel, Travel travel_db) {

    	travel_db.setTitle(travel.getTitle());
    	travel_db.setDetails(travel.getDetails());
    	travel_db.setDestiny(travel.getDestiny());
    	travel_db.setIdTravelStatus(travel.getIdTravelStatus());
    	travel_db.setOrigin(travel.getOrigin());
    	travel_db.setStart_time(travel.getStart_time());
    	travel_db.setEnd_time(travel.getEnd_time());
    	travel_db.setIdTravelType(travel.getIdTravelType());
    	travel_db.setVacancies(travel.getVacancies());
    	travel_db.setVacancies_available(travel.getVacancies_available());
    	travel_db.setIdTravelPackage(travel.getIdTravelPackage());
    	travel_db.setModifiedOn(OffsetDateTime.now());
    	return travelRepository.save(travel_db);
    }
    
    public void delete(Long id) {
    	
    	verifyIfTravelExists(id);
    	
    	Optional<Travel> travel_db = travelRepository.findById(id);
    	Travel travel = travel_db.get();
    	travel.setActive(false);
    	travelRepository.save(travel);
    
    }
    
    private void verifyIfTravelExists(Long id) {
    	Optional<Travel> travel_db = travelRepository.findById(id);;
    	if( travel_db == null) {
    		throw new NotFoundException("Travel not found"); 
    	}
    }
    
    private void validateData(Travel travel){
    	if(travel.getTitle() == null || travel.getTitle() == "" ){
    		throw new InvalidDataException();
    	}
    }
    
}
