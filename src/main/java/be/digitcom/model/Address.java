package be.digitcom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Address")
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String street;
	
	@Column(name = "`number`")
	private String number;
	
	private String postalCode;
	
	@OneToMany(
			mappedBy = "address",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<PersonAddress> owners = new ArrayList<>();

	public Address(String street, String number) {
		super();
		this.street = street;
		this.number = number;
	}

	public Address(String street, String number, String postalCode, List<PersonAddress> owners) {
		this(street, number);
		this.postalCode = postalCode;
		this.owners = owners;
	}

	public Address(String street, String number, String postalCode) {
		super();
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
	}
	
	
	
	
	
}
