package br.com.vouviajar.company.controller;

import br.com.vouviajar.company.dto.TravelPackageDTO;
import br.com.vouviajar.company.model.TravelPackage;
import br.com.vouviajar.company.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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