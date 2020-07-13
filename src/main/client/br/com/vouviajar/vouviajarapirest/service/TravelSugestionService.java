package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.Travel;
import br.com.vouviajar.vouviajarapirest.model.TravelSugestion;
import br.com.vouviajar.vouviajarapirest.repository.TravelSugestionRepository;

@Service
public class TravelSugestionService{
    
    private TravelSugestionRepository travelSugestionRepository; 

    @Autowired
    public TravelSugestionService(TravelSugestionRepository travelSugestionRepository){
        this.travelSugestionRepository = travelSugestionRepository;
    }

    public Optional<TravelSugestion> getById(Long id) {	
    	return travelSugestionRepository.findById(id);
    }

    public List<TravelSugestion> getAll() {
    	return travelSugestionRepository.findAll();
    }
    
    public TravelSugestion create(TravelSugestion travelSugestion){
        return createTravelSugestion(travelSugestion);
    }

    private TravelSugestion createTravelSugestion(TravelSugestion travelSugestion) {
    	travelSugestion.setActive(true);
    	travelSugestion.setCreatedOn(OffsetDateTime.now());
    	travelSugestion.setModifiedOn(OffsetDateTime.now());
    	return travelSugestionRepository.save(travelSugestion);
    }
    
    public TravelSugestion update(TravelSugestion travelSugestion, Long id) {
    	validateData(travelSugestion);
    	TravelSugestion travelSugestionDB = verifyIfTravelExists(id);
    	return updateTravelSugestion(travelSugestion, travelSugestionDB);
    }
    
    private TravelSugestion updateTravelSugestion(TravelSugestion travelSugestion, TravelSugestion travelSugestionDB) {
    	travelSugestionDB.setTitle(travelSugestion.getTitle());
    	travelSugestionDB.setDetails(travelSugestion.getDetails());
    	travelSugestionDB.setOrigin(travelSugestion.getOrigin());
    	travelSugestionDB.setDestiny(travelSugestion.getDestiny());
    	travelSugestionDB.setStartTime(travelSugestion.getStartTime());
    	travelSugestionDB.setEndTime(travelSugestion.getEndTime());
    	travelSugestionDB.setModifiedOn(OffsetDateTime.now());
    	return travelSugestionRepository.save(travelSugestionDB);
    }
    
    public void delete(Long id) {
    	TravelSugestion travelSugestion = verifyIfTravelExists(id);
    	travelSugestion.setActive(false);
    	travelSugestionRepository.save(travelSugestion);
    }
    
    private TravelSugestion verifyIfTravelExists(Long id) {
    	Optional<TravelSugestion> travelSugestionDB = travelSugestionRepository.findById(id);;
    	if( travelSugestionDB == null)
    		throw new NotFoundException("Travel Sugestion not found"); 
    	return travelSugestionDB.get();
    }
    
    private void validateData(TravelSugestion travelSugestion){
    	if(travelSugestion.getTitle() == null || travelSugestion.getTitle() == "" )
    		throw new InvalidDataException();
    }
}
