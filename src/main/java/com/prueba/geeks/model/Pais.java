package com.prueba.geeks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "COUNTRIES", schema = "public")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	private String id;

	@Column(name = "COUNTRY_NAME", nullable = false)
	private String nombre;
	
	@Column(name = "REGION_ID")
	private Region region;

	public Pais(String id, String nombre,  Region region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
	}
	
	public Pais() {

	}

	public Pais(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


	

}
