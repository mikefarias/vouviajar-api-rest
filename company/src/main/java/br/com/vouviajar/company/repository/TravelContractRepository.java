package br.com.vouviajar.company.repository;

import br.com.vouviajar.company.model.TravelContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TravelContractRepository extends JpaRepository<TravelContract, Long> {

    Optional<TravelContract> findById(Long idTravel);
    TravelContract findByTerms(String terms);
    
    
} 