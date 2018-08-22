package be.digitcom.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PersonAddress")
@Table(name = "`person_address`")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Person person;
	
	@Id
	@ManyToOne
	private Address address;
}
