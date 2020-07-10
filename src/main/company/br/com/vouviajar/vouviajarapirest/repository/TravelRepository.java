package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.Travel;


@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findById(Long id);
    
} 