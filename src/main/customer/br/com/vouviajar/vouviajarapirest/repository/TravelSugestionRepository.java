package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.TravelSugestion;

@Repository
public interface TravelSugestionRepository extends JpaRepository<TravelSugestion, Long> {

    Optional<TravelSugestion> findById(Long id);
        
} 