package com.nttdata.spring.repository;

import java.util.List;

/**
 * 
 * @author Jose
 *
 * Interfaz del repositorio personalizado
 */
public interface CustomPersonRepository {
	
	/**
	 * Busca un habitante por nombre y apellidos
	 * @param name (nombre)
	 * @param surnames (apellidos)
	 * @return list
	 */
	public List<Person> getResidentByNameAndSurnames(final String name, final String surnames);
	
}
