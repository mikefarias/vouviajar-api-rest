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

import br.com.vouviajar.vouviajarapirest.model.Reservation;
import br.com.vouviajar.vouviajarapirest.service.ReservationService;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Reservation> getById(@PathVariable Long id ){
    	Optional<Reservation> reservation = reservationService.getById(id);
    	if(reservation.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<Reservation>(reservation.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getAll(){
    	List<Reservation> reservations = reservationService.getAll();
    	if(reservations.isEmpty()) {
        	return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Reservation> create(@RequestBody  Reservation reservation){
    	reservationService.create(reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> update(@RequestBody  Reservation reservation, @PathVariable Long id ){
    	reservationService.update(reservation, id);    	
    	return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reservation> delete(@PathVariable Long id ){
    	reservationService.delete(id);    	
    	return new ResponseEntity<Reservation>(HttpStatus.OK);
    }

}