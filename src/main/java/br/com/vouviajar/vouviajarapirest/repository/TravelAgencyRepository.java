package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.TravelAgency;


@Repository
public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {

    Optional<TravelAgency> findById(Long idTravelAgency);
    
    TravelAgency findByCodeCadastur(String codeCadastur);
    
} 