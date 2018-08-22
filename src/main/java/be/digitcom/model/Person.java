package be.digitcom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;



@Entity(name = "Person")
@Table(name = "`people`")
public class Person  {

	@Id
	private Long id;
	
	@NaturalId
	private String registrationNumber;
	
	@OneToMany(
			mappedBy = "person",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<PersonAddress> addresses = new ArrayList<>();

	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(Long id, String registrationNumber) {
		this.id = id;
		this.registrationNumber = registrationNumber;
	}
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}





	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}





	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}





	public void addAddress(Address address) {
		PersonAddress personAddress = new PersonAddress(this, address);
		addresses.add(personAddress);
		address.getOwners().add(personAddress);
	}
	
	public void removeAddress(Address address) {
		PersonAddress personAddress = new PersonAddress(this, address);
		address.getOwners().remove(personAddress);
		addresses.remove(personAddress);
		personAddress.setPerson(null);
		personAddress.setAddress(null);
	}


	
}
