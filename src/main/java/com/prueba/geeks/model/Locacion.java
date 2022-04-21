package com.prueba.geeks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "locations", schema = "public")
public class Locacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOCATION_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "STREET_ADDRESS", nullable = false)
	private String direccion;
	
	@Column(name = "POSTAL_CODE", nullable = false)
	private String codigoPostal;
	
	@Column(name = "CITY", nullable = false)
	private String ciudad;
	
	@Column(name = "STATE_PROVINCE", nullable = false)
	private String provincia;
	
	@Column(name = "COUNTRY_ID")
	private Pais pais;

	public Locacion(Long id, String direccion, String codigoPostal, String ciudad, String provincia, Pais pais) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	

}
