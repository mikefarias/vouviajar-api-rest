package br.com.vouviajar.company.repository;

import br.com.vouviajar.company.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

    Optional<TravelPackage> findById(Long id);
    
    TravelPackage findByName(String name);
    
} 