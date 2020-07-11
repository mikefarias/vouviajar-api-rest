package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.Reservation;
import br.com.vouviajar.vouviajarapirest.repository.ReservationRepository;
import br.com.vouviajar.vouviajarapirest.repository.TravelSugestionRepository;

@Service
public class ReservationService{
    
    private ReservationRepository reservationRepository; 

    @Autowired
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> getById(Long id) {
    	
    	return reservationRepository.findById(id);
    }

    public List<Reservation> getAll() {
    	
    	return reservationRepository.findAll();
    }
    
    public Reservation create(Reservation reservation){
        

        return createReservation(reservation);
    }

    private Reservation createReservation(Reservation reservation) {
    	
    	reservation.setActive(true);
    	reservation.setCreatedOn(OffsetDateTime.now());
    	reservation.setModifiedOn(OffsetDateTime.now());
    	return reservationRepository.save(reservation);
    }
    
    public Reservation update(Reservation reservation, Long id) {
    	  
    	Optional<Reservation> reservation_db = reservationRepository.findById(id);;
    	if( reservation_db == null) {
    		throw new NotFoundException("Reservation not found"); 
    	}
    	
    	return updateReservation(reservation, reservation_db.get());
    }
    
    private Reservation updateReservation(Reservation reservation, Reservation reservation_db) {
    	
				 
    	reservation_db.setModifiedOn(OffsetDateTime.now());
    	
    	return reservationRepository.save(reservation_db);
    }
    
    public void delete(Long id) {
    	
    	Optional<Reservation> reservation_db = reservationRepository.findById(id);;
    	if( reservation_db == null) {
    		throw new NotFoundException("Reservation not found"); 
    	}
    	Reservation reservation = reservation_db.get();
    	reservation.setActive(false);
    	reservationRepository.save(reservation);
    	
    }
}
