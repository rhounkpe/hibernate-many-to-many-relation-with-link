package be.digitcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.digitcom.model.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
