package br.com.vouviajar.customer.repository;

import br.com.vouviajar.customer.model.TravelSugestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelSugestionRepository extends JpaRepository<TravelSugestion, Long> {

    Optional<TravelSugestion> findById(Long id);
        
} 