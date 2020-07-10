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

import br.com.vouviajar.vouviajarapirest.dto.TravelContractDTO;
import br.com.vouviajar.vouviajarapirest.model.TravelContract;
import br.com.vouviajar.vouviajarapirest.service.TravelContractService;

@RestController
@RequestMapping("/api/v1")
public class TravelContractController {

    private TravelContractService travelContractService;

    @Autowired
    public TravelContractController(TravelContractService travelContractService){
        this.travelContractService = travelContractService;
    }
    
    @RequestMapping(value = "/travel-contract/{id}", method = RequestMethod.GET)
    public ResponseEntity<TravelContractDTO> getById(@PathVariable Long id ){
    	Optional<TravelContract> travelContract = travelContractService.getById(id);
    	if(travelContract.isEmpty()) {
        	return new ResponseEntity<TravelContractDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<TravelContractDTO>(TravelContractDTO.toDTO(travelContract), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-contract", method = RequestMethod.GET)
    public ResponseEntity<List<TravelContractDTO>> getAll(){
    	List<TravelContract> travelContracts = travelContractService.getAll();
    	if(travelContracts.isEmpty()) {
        	return new ResponseEntity<List<TravelContractDTO>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<TravelContractDTO>>(TravelContractDTO.toDTO(travelContracts), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/travel-contract", method = RequestMethod.POST)
    public ResponseEntity<TravelContractDTO> create(@RequestBody TravelContractDTO travelContractDTO){
        TravelContract travelContract = travelContractService.create(travelContractDTO.toTravelContract());
        return new ResponseEntity<TravelContractDTO>(TravelContractDTO.toDTO(travelContract), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/travel-contract/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TravelContractDTO> update(@RequestBody TravelContractDTO travelContractDTO, @PathVariable Long id ){
    	TravelContract travelContract = travelContractService.update(travelContractDTO.toTravelContract(), id);    	
    	return new ResponseEntity<TravelContractDTO>(TravelContractDTO.toDTO(travelContract), HttpStatus.OK);
    }

    @RequestMapping(value = "/travel-contract/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TravelContractDTO> delete(@PathVariable Long id ){
    	travelContractService.delete(id);    	
    	return new ResponseEntity<>( HttpStatus.OK);
    }

}