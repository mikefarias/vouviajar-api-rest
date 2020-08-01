package br.com.vouviajar.company.repository;

import br.com.vouviajar.company.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findById(Long id);
    
} 