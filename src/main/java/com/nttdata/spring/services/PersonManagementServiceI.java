package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.Floor;
import com.nttdata.spring.repository.Person;

/**
 * Interfaz de PersonManagementBuilding
 * @author Jose
 *
 */
public interface PersonManagementServiceI {
	
	/**
	 * Devuelve todos los habitantes del edificio
	 * @return list
	 */
	public List<Person> getAllResidents();
	
	/**
	 * Busca si existe un habitante por nombre y apellidos
	 * @param name (nombre)
	 * @param surnames (apellidos)
	 * @return list
	 */
	public List<Person> getResidentByNameAndSurnames(final String name, final String surnames);
	
	/**
	 * Inserta una persona
	 * @param p (person)
	 */
	public void insertPerson(Person p);
	
	/**
	 * Borra una persona
	 * @param id (id)
	 */
	public void deletePerson(Long id);
	
	/**
	 * Inserta una planta
	 * @param f (floor)
	 */
	public void insertFloor(Floor f);
	
	/**
	 * Borra una planta
	 * @param id (id)
	 */
	public void deleteFloor(Long id);
	
	/**
	 * Inserta un departamento
	 * @param a (apartment)
	 */
	public void insertApartment(Apartment a);
	
	/**
	 * Borra un departamento
	 * @param id (id)
	 */
	public void deleteApartment(Long id);
}
