package br.com.vouviajar.vouviajarapirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajarapirest.dto.TravelSugestionDTO;
import br.com.vouviajar.vouviajarapirest.model.TravelSugestion;
import br.com.vouviajar.vouviajarapirest.service.TravelSugestionService;

@RestController
@RequestMapping("/api/v1")
public class TravelSugestionController {

    private TravelSugestionService travelSugestionService;

    @Autowired
    public TravelSugestionController(TravelSugestionService travelSugestionService){
        this.travelSugestionService = travelSugestionService;
    }
    
    @RequestMapping(value = "/travel-sugestion/{id}", method = RequestMethod.GET)
    public ResponseEntity<TravelSugestionDTO> getById(@PathVariable Long id ){
    	Optional<TravelSugestion> travelSugestion = travelSugestionService.getById(id);
    	if(travelSugestion.isEmpty()) {
        	return new ResponseEntity<TravelSugestionDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<TravelSugestionDTO>(TravelSugestionDTO.toDTO(travelSugestion), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-sugestion", method = RequestMethod.GET)
    public ResponseEntity<List<TravelSugestionDTO>> getAll(){
    	List<TravelSugestion> travelSugestions = travelSugestionService.getAll();
    	if(travelSugestions.isEmpty()) {
        	return new ResponseEntity<List<TravelSugestionDTO>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<TravelSugestionDTO>>(TravelSugestionDTO.toDTO(travelSugestions), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/travel-sugestion", method = RequestMethod.POST)
    public ResponseEntity<TravelSugestionDTO> create(@RequestBody TravelSugestionDTO travelSugestionDTO){
        TravelSugestion travelSugestion = travelSugestionService.create(travelSugestionDTO.toTravelSugestion());
        return new ResponseEntity<TravelSugestionDTO>(TravelSugestionDTO.toDTO(travelSugestion), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/travel-sugestion/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TravelSugestionDTO> update(@RequestBody TravelSugestionDTO travelSugestionDTO, @PathVariable Long id ){
    	TravelSugestion travelSugestion = travelSugestionService.update(travelSugestionDTO.toTravelSugestion(), id);    	
    	return new ResponseEntity<TravelSugestionDTO>(TravelSugestionDTO.toDTO(travelSugestion), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-sugestion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TravelSugestionDTO> delete(@PathVariable Long id ){
    	travelSugestionService.delete(id);    	
    	return new ResponseEntity<>( HttpStatus.OK);
    }

}