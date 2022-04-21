package com.prueba.geeks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "regions", schema = "public")
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "REGION_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "REGION_NAME", nullable = false)
	private String nombre;


	public Region(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Region() {

	}

	public Region(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
