package br.com.vouviajar.company.controller;

import br.com.vouviajar.company.dto.TravelAgencyDTO;
import br.com.vouviajar.company.model.TravelAgency;
import br.com.vouviajar.company.service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TravelAgencyController {

    private TravelAgencyService travelAgencyService;

    @Autowired
    public TravelAgencyController(TravelAgencyService travelAgencyService){
        this.travelAgencyService = travelAgencyService;
    }
    
    @RequestMapping(value = "/travel-agency/{id}", method = RequestMethod.GET)
    public ResponseEntity<TravelAgencyDTO> getById(@PathVariable Long id ){
    	Optional<TravelAgency> travelAgency = travelAgencyService.getById(id);
    	if(travelAgency.isEmpty()) {
        	return new ResponseEntity<TravelAgencyDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<TravelAgencyDTO>(TravelAgencyDTO.toDTO(travelAgency), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-agency", method = RequestMethod.GET)
    public ResponseEntity<List<TravelAgencyDTO>> getAll(){
    	List<TravelAgency> travelAgencys = travelAgencyService.getAll();
    	if(travelAgencys.isEmpty()) {
        	return new ResponseEntity<List<TravelAgencyDTO>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<TravelAgencyDTO>>(TravelAgencyDTO.toDTO(travelAgencys), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/travel-agency", method = RequestMethod.POST)
    public ResponseEntity<TravelAgencyDTO> create(@RequestBody TravelAgencyDTO travelAgencyDTO){
        TravelAgency travelAgency = travelAgencyService.create(travelAgencyDTO.toTravelAgency());
        return new ResponseEntity<TravelAgencyDTO>(TravelAgencyDTO.toDTO(travelAgency), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/travel-agency/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TravelAgencyDTO> update(@RequestBody TravelAgencyDTO travelAgencyDTO, @PathVariable Long id ){
    	TravelAgency travelAgency = travelAgencyService.update(travelAgencyDTO.toTravelAgency(), id);    	
    	return new ResponseEntity<TravelAgencyDTO>(TravelAgencyDTO.toDTO(travelAgency), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-agency/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TravelAgencyDTO> delete(@PathVariable Long id ){
    	travelAgencyService.delete(id);    	
    	return new ResponseEntity<>( HttpStatus.OK);
    }

}