package br.com.vouviajar.vouviajarapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

} 