package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jose
 *
 * Repositorio de departamentos
 */
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
	
}
