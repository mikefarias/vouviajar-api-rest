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

import br.com.vouviajar.vouviajarapirest.dto.TravelPackageDTO;
import br.com.vouviajar.vouviajarapirest.model.TravelPackage;
import br.com.vouviajar.vouviajarapirest.service.TravelPackageService;

@RestController
@RequestMapping("/api/v1")
public class TravelPackageController {

    private TravelPackageService travelPackageService;

    @Autowired
    public TravelPackageController(TravelPackageService travelPackageService){
        this.travelPackageService = travelPackageService;
    }
    
    @RequestMapping(value = "/travel-package/{id}", method = RequestMethod.GET)
    public ResponseEntity<TravelPackageDTO> getById(@PathVariable Long id ){
    	Optional<TravelPackage> travelPackage = travelPackageService.getById(id);
    	if(travelPackage.isEmpty()) {
        	return new ResponseEntity<TravelPackageDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<TravelPackageDTO>(TravelPackageDTO.toDTO(travelPackage), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-package", method = RequestMethod.GET)
    public ResponseEntity<List<TravelPackageDTO>> getAll(){
    	List<TravelPackage> travelPackages = travelPackageService.getAll();
    	if(travelPackages.isEmpty()) {
        	return new ResponseEntity<List<TravelPackageDTO>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<TravelPackageDTO>>(TravelPackageDTO.toDTO(travelPackages), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/travel-package", method = RequestMethod.POST)
    public ResponseEntity<TravelPackageDTO> create(@RequestBody TravelPackageDTO travelPackageDTO){
        TravelPackage travelPackage = travelPackageService.create(travelPackageDTO.toTravelPackage());
        return new ResponseEntity<TravelPackageDTO>(TravelPackageDTO.toDTO(travelPackage), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/travel-package/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TravelPackageDTO> update(@RequestBody TravelPackageDTO travelPackageDTO, @PathVariable Long id ){
    	TravelPackage travelPackage = travelPackageService.update(travelPackageDTO.toTravelPackage(), id);    	
    	return new ResponseEntity<TravelPackageDTO>(TravelPackageDTO.toDTO(travelPackage), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-package/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TravelPackageDTO> delete(@PathVariable Long id ){
    	travelPackageService.delete(id);    	
    	return new ResponseEntity<>( HttpStatus.OK);
    }

}