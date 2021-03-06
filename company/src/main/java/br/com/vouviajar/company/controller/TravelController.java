package br.com.vouviajar.company.controller;

import br.com.vouviajar.company.dto.TravelDTO;
import br.com.vouviajar.company.model.Travel;
import br.com.vouviajar.company.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TravelController {

    private TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService){
        this.travelService = travelService;
    }
    
    @RequestMapping(value = "/travel/{id}", method = RequestMethod.GET)
    public ResponseEntity<TravelDTO> getById(@PathVariable Long id ){
    	Optional<Travel> travel = travelService.getById(id);
    	if(travel.isEmpty()) {
        	return new ResponseEntity<TravelDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<TravelDTO>(TravelDTO.toDTO(travel), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel", method = RequestMethod.GET)
    public ResponseEntity<List<TravelDTO>> getAll(){
    	List<Travel> travels = travelService.getAll();
    	if(travels.isEmpty()) {
        	return new ResponseEntity<List<TravelDTO>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<TravelDTO>>(TravelDTO.toDTO(travels), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/travel", method = RequestMethod.POST)
    public ResponseEntity<TravelDTO> create(@RequestBody TravelDTO travelDTO){
        Travel travel = travelService.create(travelDTO.toTravel());
        return new ResponseEntity<TravelDTO>(TravelDTO.toDTO(travel), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/travel/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TravelDTO> update(@RequestBody TravelDTO travelDTO, @PathVariable Long id ){
    	Travel travel = travelService.update(travelDTO.toTravel(), id);    	
    	return new ResponseEntity<TravelDTO>(TravelDTO.toDTO(travel), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TravelDTO> delete(@PathVariable Long id ){
    	travelService.delete(id);    	
    	return new ResponseEntity<>( HttpStatus.OK);
    }

}