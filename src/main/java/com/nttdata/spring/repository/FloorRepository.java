package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jose
 *
 * Repositorio de plantas
 */
@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {
	
}
