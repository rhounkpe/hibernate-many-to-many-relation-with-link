package be.digitcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.digitcom.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
