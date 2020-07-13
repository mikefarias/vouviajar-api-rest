package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.DataAlreadyExistsException;
import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.TravelContract;
import br.com.vouviajar.vouviajarapirest.repository.TravelContractRepository;

@Service
public class TravelContractService{
    
    private TravelContractRepository travelContractRepository; 

    @Autowired
    public TravelContractService(TravelContractRepository travelContractRepository){
        this.travelContractRepository = travelContractRepository;
    }

    public Optional<TravelContract> getById(Long id) {
    	return travelContractRepository.findById(id);
    }

    public List<TravelContract> getAll() {
    	return travelContractRepository.findAll();
    }
    
    public TravelContract create(TravelContract travelContract){
    	validateData(travelContract);
    	if(travelContractRepository.findByTerms(travelContract.getTerms()) != null) 
    		throw new DataAlreadyExistsException("Travel Contract already exists"); 
        return createTravelContract(travelContract);
    }

    private TravelContract createTravelContract(TravelContract travelContract) {
    	travelContract.setActive(true);
    	travelContract.setCreatedOn(OffsetDateTime.now());
    	travelContract.setModifiedOn(OffsetDateTime.now());
    	return travelContractRepository.save(travelContract);
    }
    
    public TravelContract update(TravelContract travelContract, Long id) {
    	validateData(travelContract);
    	TravelContract travelContractDB = verifyIfUserExists(id);
    	return updateTravelContract(travelContract, travelContractDB);
    }
    
    private TravelContract updateTravelContract(TravelContract travelContract, TravelContract travelContractDB) {
    	travelContractDB.setTerms(travelContract.getTerms());
		travelContractDB.setModifiedOn(OffsetDateTime.now());
    	return travelContractRepository.save(travelContractDB);
    }
    
    public void delete(Long id) {
    	TravelContract travelContract = verifyIfUserExists(id);
    	travelContract.setActive(false);
    	travelContractRepository.save(travelContract);
    }
    
    private TravelContract verifyIfUserExists(Long id) {
    	Optional<TravelContract> travelContractDB = travelContractRepository.findById(id);;
    	if( travelContractDB == null)
    		throw new NotFoundException("Travel Contract not found"); 
    	return travelContractDB.get();
    }
    
    private void validateData(TravelContract travelContract) {
 		if(travelContract.getTerms() == null || travelContract.getTerms() == "" ) 
			throw new InvalidDataException();
    }
}