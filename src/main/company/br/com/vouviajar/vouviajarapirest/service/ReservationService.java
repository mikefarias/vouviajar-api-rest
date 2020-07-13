package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.model.Reservation;
import br.com.vouviajar.vouviajarapirest.repository.ReservationRepository;

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
		Reservation reservationDB = verifyIfUserExists(id);
		return updateReservation(reservation, reservationDB);
	}

	private Reservation updateReservation(Reservation reservation, Reservation reservationDB) {
		reservationDB.setModifiedOn(OffsetDateTime.now());
		return reservationRepository.save(reservationDB);
	}

	public void delete(Long id) {
		Reservation reservation = verifyIfUserExists(id);
		reservation.setActive(false);
		reservationRepository.save(reservation);
	}
	
    private Reservation verifyIfUserExists(Long id) {
    	Optional<Reservation> reservationDB = reservationRepository.findById(id);;
    	if( reservationDB  == null)
    		throw new NotFoundException("Reservation not found"); 	
    	return reservationDB.get();
    }
}