package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jose
 *
 * Interfaz del repositorio personalizado
 */
@Repository
public interface PersonRepositoryI extends JpaRepository<Person,Long>,CustomPersonRepository{

	public List<Person> getResidentByNameAndSurnames(final String name, final String surnames);
	
}
