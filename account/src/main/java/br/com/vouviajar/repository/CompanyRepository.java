package br.com.vouviajar.repository;

import br.com.vouviajar.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCnpj(String cnpj);

    Optional<Company> findById(Long idCompany);
} 