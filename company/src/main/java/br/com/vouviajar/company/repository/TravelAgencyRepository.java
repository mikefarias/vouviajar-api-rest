package br.com.vouviajar.company.repository;

import br.com.vouviajar.company.model.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {

    Optional<TravelAgency> findById(Long idTravelAgency);
    
    TravelAgency findByCodeCadastur(String codeCadastur);
    
} 