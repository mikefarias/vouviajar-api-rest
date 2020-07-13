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
    	validateData(travel);
    	Travel travelDB = verifyIfTravelExists(id);
    	return updateTravel(travel, travelDB);
    }
    
    private Travel updateTravel(Travel travel, Travel travelDB) {
    	travelDB.setTitle(travel.getTitle());
    	travelDB.setDetails(travel.getDetails());
    	travelDB.setDestiny(travel.getDestiny());
    	travelDB.setIdTravelStatus(travel.getIdTravelStatus());
    	travelDB.setOrigin(travel.getOrigin());
    	travelDB.setStartTime(travel.getStartTime());
    	travelDB.setEndTime(travel.getEndTime());
    	travelDB.setIdTravelType(travel.getIdTravelType());
    	travelDB.setVacancies(travel.getVacancies());
    	travelDB.setVacanciesAvailable(travel.getVacanciesAvailable());
    	travelDB.setIdTravelPackage(travel.getIdTravelPackage());
    	travelDB.setModifiedOn(OffsetDateTime.now());
    	return travelRepository.save(travelDB);
    }
    
    public void delete(Long id) {
    	Travel travel = verifyIfTravelExists(id);
    	travel.setActive(false);
    	travelRepository.save(travel);
    }
    
    private Travel verifyIfTravelExists(Long id) {
    	Optional<Travel> travelDB = travelRepository.findById(id);;
    	if( travelDB == null)
    		throw new NotFoundException("Travel not found"); 
    	return travelDB.get();
    }
    
    private void validateData(Travel travel){
    	if(travel.getTitle() == null || travel.getTitle() == "" )
    		throw new InvalidDataException();
    }
}