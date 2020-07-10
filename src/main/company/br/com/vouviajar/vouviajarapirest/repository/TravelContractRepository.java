package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.TravelContract;


@Repository
public interface TravelContractRepository extends JpaRepository<TravelContract, Long> {

    Optional<TravelContract> findById(Long idTravel);
    TravelContract findByTerms(String terms);
    
    
} 