package com.nttdata.spring.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Persona
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "PERSON")
public class Person extends AbstractEntity implements Serializable {
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long personId;

	/** Nombre */
	private String name;

	/** Apellidos */
	private String surnames;
	
	/** Apartamentos asociados */
	private List<Apartment> apartments;

	/**
	 * Devuelve el id del cliente
	 * @return customerId (id)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Coloca el id de la persona
	 * @param personId (id)
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Devuelve el nombre
	 * @return name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Coloca el nombre
	 * @param name nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve los apellidos
	 * @return surnames
	 */
	@Column(name = "SURNAMES")
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Coloca los apellidos
	 * @param surnames (apellidos)
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	
	/**
	 * Devuelve los departamentos asociados
	 * @return apartments
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "person")
	public List<Apartment> getApartments() {
		return apartments;
	}

	/**
	 * Coloca los departamentos asociados
	 * @param apartments (apartamentos)
	 */
	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", surnames=" + surnames + "]";
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Person.class;
	}
}
