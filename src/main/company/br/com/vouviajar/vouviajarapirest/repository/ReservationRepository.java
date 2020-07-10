package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.Reservation;
import br.com.vouviajar.vouviajarapirest.model.TravelPackage;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findById(Long id);
        
} 