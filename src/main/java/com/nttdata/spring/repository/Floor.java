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
 * Clase Planta
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "FLOOR")
public class Floor extends AbstractEntity implements Serializable {
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long floorId;

	
	/** Numero de planta **/
	private Long floorNumber;
	
	/** Numero de departamentos **/
	private Long apartmentsNumber;
	
	/** Departamentos asociados */
	private List<Apartment> apartments;

	/**
	 * Devuelve el id de la planta
	 * @return floorId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FLOOR_ID")
	public Long getFloorId() {
		return floorId;
	}

	/**
	 * Coloca el id de la planta
	 * @param floorId (id)
	 */
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	/**
	 * Devuelve el piso de la planta
	 * @return floorNumber
	 */
	@Column(name = "FLOOR_NUMBER")
	public Long getFloorNumber() {
		return floorNumber;
	}
	
	/**
	 * Devuelve el numero de departamentos que posee
	 * @return apartmentsNumber
	 */
	@Column(name = "APARTMENTS_NUMBER")
	public Long getApartmentsNumber() {
		return apartmentsNumber;
	}
	
	/**
	 * Coloca el piso de la planta
	 * @param floorNumber (piso)
	 */
	public void setFloorNumber(Long floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	/**
	 * Coloca el numero de departamentos que posee
	 * @param apartmentsNumber (numeroDeApartamentos)
	 */
	public void setApartmentsNumber(Long apartmentsNumber) {
		this.apartmentsNumber = apartmentsNumber;
	}
	
	
	/**
	 * Devuelve los apartamentos
	 * @return apartments
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "floor")
	public List<Apartment> getApartments() {
		return apartments;
	}

	/**
	 * Coloca los apartamentos
	 * @param apartments (apartamentos)
	 */
	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", floorNumber=" + floorNumber + ", apartmentsNumber=" + apartmentsNumber
				+ "]";
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Floor.class;
	}
}
