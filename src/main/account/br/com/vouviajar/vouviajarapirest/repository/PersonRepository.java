package br.com.vouviajar.vouviajarapirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajarapirest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Person> findById(Long idPerson);
} 