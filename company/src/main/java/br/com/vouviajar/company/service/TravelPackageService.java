package br.com.vouviajar.company.service;

import br.com.vouviajar.company.exception.DataAlreadyExistsException;
import br.com.vouviajar.company.exception.InvalidDataException;
import br.com.vouviajar.company.exception.NotFoundException;
import br.com.vouviajar.company.model.TravelPackage;
import br.com.vouviajar.company.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageService{
    
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    public TravelPackageService(TravelPackageRepository travelPackageRepository){
        this.travelPackageRepository = travelPackageRepository;
    }

    public Optional<TravelPackage> getById(Long id) {
    	return travelPackageRepository.findById(id);
    }

    public List<TravelPackage> getAll() {
    	return travelPackageRepository.findAll();
    }
    
    public TravelPackage create(TravelPackage travelPackage){
    	validateData(travelPackage);
    	if(travelPackageRepository.findByName(travelPackage.getName()) != null)
    		throw new DataAlreadyExistsException("Travel Package already exists");
        return createTravelPackage(travelPackage);
    }

    private TravelPackage createTravelPackage(TravelPackage travelPackage) {
    	travelPackage.setActive(true);
    	travelPackage.setCreatedOn(OffsetDateTime.now());
    	travelPackage.setModifiedOn(OffsetDateTime.now());
    	return travelPackageRepository.save(travelPackage);
    }
    
    public TravelPackage update(TravelPackage travelPackage, Long id) {
    	validateData(travelPackage);
    	TravelPackage travelPackageDB = verifyIfUserExists(id);
    	return updateTravelPackage(travelPackage, travelPackageDB);
    }
    
    private TravelPackage updateTravelPackage(TravelPackage travelPackage, TravelPackage travelPackage_db) {
		travelPackage_db.setName(travelPackage.getName());
		travelPackage_db.setInvestiment(travelPackage.getInvestiment());
    	travelPackage_db.setModifiedOn(OffsetDateTime.now());
    	return travelPackageRepository.save(travelPackage_db);
    }
    
    public void delete(Long id) {
    	TravelPackage travelPackage = verifyIfUserExists(id);
    	travelPackage.setActive(false);
    	travelPackageRepository.save(travelPackage);
    }
    
    private TravelPackage verifyIfUserExists(Long id) {
    	Optional<TravelPackage> travelPackageDB = travelPackageRepository.findById(id);;
    	if( travelPackageDB== null)
    		throw new NotFoundException("Travel Package not found"); 
    	return travelPackageDB.get();
    }
    
    private void validateData(TravelPackage travelPackage) {
		if(travelPackage.getName() == null || travelPackage.getName() == "" ) 
			throw new InvalidDataException("Invalid Name");
    }
}