package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
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
    	  
    	Optional<TravelSugestion> travelSugestion_db = travelSugestionRepository.findById(id);;
    	if( travelSugestion_db == null) {
    		throw new NotFoundException("TravelSugestion not found"); 
    	}
    	
    	return updateTravelSugestion(travelSugestion, travelSugestion_db.get());
    }
    
    private TravelSugestion updateTravelSugestion(TravelSugestion travelSugestion, TravelSugestion travelSugestion_db) {
				
    	travelSugestion_db.setTitle(travelSugestion.getTitle());
    	travelSugestion_db.setDetails(travelSugestion.getDetails());
    	travelSugestion_db.setOrigin(travelSugestion.getOrigin());
    	travelSugestion_db.setDestiny(travelSugestion.getDestiny());
    	travelSugestion_db.setStartTime(travelSugestion.getStartTime());
    	travelSugestion_db.setEndTime(travelSugestion.getEndTime());
    	travelSugestion_db.setModifiedOn(OffsetDateTime.now());
    	
    	return travelSugestionRepository.save(travelSugestion_db);
    }
    
    public void delete(Long id) {
    	
    	Optional<TravelSugestion> travelSugestion_db = travelSugestionRepository.findById(id);;
    	if( travelSugestion_db == null) {
    		throw new NotFoundException("TravelSugestion not found"); 
    	}
    	TravelSugestion travelSugestion = travelSugestion_db.get();
    	travelSugestion.setActive(false);
    	travelSugestionRepository.save(travelSugestion);
    	
    }
}
