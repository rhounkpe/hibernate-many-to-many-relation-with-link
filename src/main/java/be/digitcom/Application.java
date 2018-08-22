package be.digitcom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.digitcom.model.Address;
import be.digitcom.model.Person;
import be.digitcom.repository.IAddressRepository;
import be.digitcom.repository.IPersonRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	private IPersonRepository personRepository;
	
	@Autowired
	private IAddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runIt() {
		Person person1 = new Person(1L, "ABC-123");
		Person person2 = new Person(2L, "DEF-456");

		Address address1 = new Address( "12th Avenue", "12A", "4005A" );
		Address address2 = new Address( "18th Avenue", "18B", "4007B" );

		/*
		person1.addAddress( address1 );
		person1.addAddress( address2 );
		person2.addAddress( address1 );
		*/
		
		return args -> {
			personRepository.save(person1);
			/*
			personRepository.save(person2);
			addressRepository.save(address1);
			addressRepository.save(address2);
			*/
		};
	}
}
