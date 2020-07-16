package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

    Optional<Company> findById(Long idCompany);
} 