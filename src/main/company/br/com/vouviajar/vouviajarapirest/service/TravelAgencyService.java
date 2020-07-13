package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.DataAlreadyExistsException;
import br.com.vouviajar.vouviajarapirest.exception.InvalidDataException;
import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.TravelAgency;
import br.com.vouviajar.vouviajarapirest.repository.TravelAgencyRepository;

@Service
public class TravelAgencyService{

	private TravelAgencyRepository travelAgencyRepository; 

	@Autowired
	public TravelAgencyService(TravelAgencyRepository travelAgencyRepository){
		this.travelAgencyRepository = travelAgencyRepository;
	}

	public Optional<TravelAgency> getById(Long id) {
		return travelAgencyRepository.findById(id);
	}

	public List<TravelAgency> getAll() {
		return travelAgencyRepository.findAll();
	}

	public TravelAgency create(TravelAgency travelAgency){
		validateData(travelAgency);
		if(travelAgencyRepository.findByCodeCadastur(travelAgency.getCodeCadastur()) != null)
			throw new DataAlreadyExistsException("Travel Agency already exists");           
		return createTravelAgency(travelAgency);
	}

	private TravelAgency createTravelAgency(TravelAgency travelAgency) {
		travelAgency.setActive(true);
		travelAgency.setCreatedOn(OffsetDateTime.now());
		travelAgency.setModifiedOn(OffsetDateTime.now());
		return travelAgencyRepository.save(travelAgency);
	}

	public TravelAgency update(TravelAgency travelAgency, Long id) {
		validateData(travelAgency);
		TravelAgency travelAgencyDB = verifyIfUserExists(id);
		return updateTravelAgency(travelAgency, travelAgencyDB);
	}

	private TravelAgency updateTravelAgency(TravelAgency travelAgency, TravelAgency travelAgencyDB) {
		travelAgencyDB.setCodeCadastur(travelAgency.getCodeCadastur());
		travelAgencyDB.setPhysicalAgency(travelAgency.isPhysicalAgency());
		travelAgencyDB.setModifiedOn(OffsetDateTime.now());
		return travelAgencyRepository.save(travelAgencyDB);
	}

	public void delete(Long id) {
		TravelAgency travelAgency = verifyIfUserExists(id);
		travelAgency.setActive(false);
		travelAgencyRepository.save(travelAgency);
	}
	
    private TravelAgency verifyIfUserExists(Long id) {
		Optional<TravelAgency> travelAgencyDB = travelAgencyRepository.findById(id);;
		if( travelAgencyDB == null)
			throw new NotFoundException("Travel Agency not found"); 
		return travelAgencyDB.get();
    }
    
    private void validateData(TravelAgency travelAgency) {
		if(travelAgency.getCodeCadastur() == null || travelAgency.getCodeCadastur() == "" )
			throw new InvalidDataException();
    }
}