package com.nttdata.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.Floor;
import com.nttdata.spring.repository.Person;
import com.nttdata.spring.services.PersonManagementServiceI;

/**
 * Clase principal
 * 
 * @author Jose
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {
	
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);

	
	@Autowired
	private PersonManagementServiceI personService;
	
	/**
	 * Metodo principal
	 * @param args (main)
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Creacion de personas
		final Person person1 = new Person();
		person1.setName("Juan");
		person1.setSurnames("Perez Caro");
		
		final Person person2 = new Person();
		person2.setName("Maria");
		person2.setSurnames("Morales Garcia");
		
		final Person person3 = new Person();
		person3.setName("Raul");
		person3.setSurnames("Lopez Jimenez");
		
		
		// Inserciones de personas
		personService.insertPerson(person1);
		personService.insertPerson(person2);
		personService.insertPerson(person3);
		
		// Borrado de la persona con id 3
		personService.deletePerson(3L);
		
		// Creacion de plantas
		final Floor floor1 = new Floor();
		floor1.setFloorNumber(0L);
		floor1.setApartmentsNumber(2L);
		
		final Floor floor2 = new Floor();
		floor1.setFloorNumber(1L);
		floor1.setApartmentsNumber(4L);
		
		// Inserciones de plantas
		personService.insertFloor(floor1);
		personService.insertFloor(floor2);
		
		// Se borra una planta
		personService.deleteFloor(5L);
		
		// Creacion de apartamentos
		Apartment apa1 = new Apartment();
		apa1.setApartmentNumber(1L);
		apa1.setPerson(person1);
		apa1.setFloor(floor1);
		
		Apartment apa2 = new Apartment();
		apa2.setApartmentNumber(2L);
		apa2.setPerson(person2);
		apa2.setFloor(floor1);
		
		// Inserciones de apartamentos
		personService.insertApartment(apa1);
		personService.insertApartment(apa2);
		
		
		// Busca al habitante Juan Perez Caro
		final List<Person> results = personService.getResidentByNameAndSurnames("Juan","Perez Caro");
		for (final Person ee : results) {
			log.info("Id: {} | Nombre: {} | Apellidos: {}", ee.getPersonId(), ee.getName(), ee.getSurnames());
		}
		
		// Busca todos los habitantes del edificio
		final List<Person> allResults = personService.getAllResidents();
		for(final Person ee : allResults) {
			log.info("Id: {} | Nombre: {} | Apellidos: {}", ee.getPersonId(), ee.getName(), ee.getSurnames());
		}
		
		
	}

}
