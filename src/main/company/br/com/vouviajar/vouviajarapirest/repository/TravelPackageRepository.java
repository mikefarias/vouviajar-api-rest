package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.TravelPackage;


@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

    Optional<TravelPackage> findById(Long id);
    
    TravelPackage findByName(String name);
    
} 