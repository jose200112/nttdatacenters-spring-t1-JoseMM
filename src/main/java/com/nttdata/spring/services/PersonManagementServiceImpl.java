package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.ApartmentRepository;
import com.nttdata.spring.repository.CustomPersonRepositoryImpl;
import com.nttdata.spring.repository.Floor;
import com.nttdata.spring.repository.FloorRepository;
import com.nttdata.spring.repository.Person;
import com.nttdata.spring.repository.PersonRepositoryI;

/**
 * Servicio persona
 * 
 * @author Jose
 *
 */
@Service
public class PersonManagementServiceImpl implements PersonManagementServiceI {
	
	@Autowired
	CustomPersonRepositoryImpl repo;
	
	@Autowired
	PersonRepositoryI personRepo;
	
	@Autowired
	FloorRepository floorRepo;
	
	@Autowired
	ApartmentRepository apaRepo;

	@Override
	public List<Person> getAllResidents() {
		return personRepo.findAll();
	}

	@Override
	public List<Person> getResidentByNameAndSurnames(final String name, final String surnames) {
		return repo.getResidentByNameAndSurnames(name,surnames);
	}

	@Override
	public void insertPerson(Person p) {
		
		personRepo.save(p);
	}

	@Override
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
		
	}
	

	@Override
	public void insertFloor(Floor f) {
		floorRepo.save(f);
		
	}

	@Override
	public void deleteFloor(Long id) {
		floorRepo.deleteById(id);
	}

	@Override
	public void insertApartment(Apartment a) {
		apaRepo.save(a);
	}

	@Override
	public void deleteApartment(Long id) {
		apaRepo.deleteById(id);
	}
	
	

	
	
}
