package com.nttdata.spring.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Departamento
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "APARTMENT")
public class Apartment extends AbstractEntity implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Identificador (PK) */
	private Long apartmentId;
	
	
	/** Numero de apartamento **/
	private Long apartmentNumber;
	
	/** Persona asociada (FK) */
	private Person personId;
	
	/** Planta asociada (FK) */
	private Floor floorId;
	
	/**
	 * Devuelve el id del departamento
	 * @return apartmentId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APARTMENT_ID")
	public Long getApartmentId() {
		return apartmentId;
	}
	
	/**
	 * Coloca el id del departamento
	 * @param apartmentId ()
	 */
	public void setApartmentId(Long apartmentId) {
		this.apartmentId = apartmentId;
	}
	
	
	
	/**
	 * Coloca el numero de departamento
	 * @param apartmentNumber (numeroDeApartamento)
	 */
	public void setApartmentNumber(Long apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	/**
	 * Devuelve el numero de departamento
	 * @return apartmentNumber
	 */
	@Column(name = "APARTMENT_NUMBER")
	public Long getApartmentNumber() {
		return apartmentNumber;
	}
	
	/**
	 * Devuelve la persona asociada
	 * @return personId
	 */
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	public Person getPerson() {
		return personId;
	}

	
	/**
	 * Coloca la persona asociada
	 * @param personId (id)
	 */
	public void setPerson(Person personId) {
		this.personId = personId;
	}
	
	/**
	 * Devuelve la planta asociada
	 * @return floorId
	 */
	@ManyToOne
	@JoinColumn(name = "FLOOR_ID")
	public Floor getFloor() {
		return floorId;
	}
	
	/**
	 * Coloca la planta asociada
	 * @param floorId (id)
	 */
	public void setFloor(Floor floorId) {
		this.floorId = floorId;
	}
	
	
	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Apartment.class;
	}
	
}
