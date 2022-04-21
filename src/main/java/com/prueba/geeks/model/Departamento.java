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
@Table(name = "DEPARTAMENTS", schema = "public")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEPARTAMENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DEPARTAMENT_NAME", nullable = false)
	private String nombre;
	
	@Column(name = "LOCACION_ID")
	private Locacion locacion;
	
	@Column(name = "MANAGER_ID")
	private Empleado gerente;

	public Departamento(Long id, String nombre, Locacion locacion, Empleado gerente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.locacion = locacion;
		this.gerente = gerente;
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

	public Locacion getLocacion() {
		return locacion;
	}

	public void setLocacion(Locacion locacion) {
		this.locacion = locacion;
	}

	public Empleado getGerente() {
		return gerente;
	}

	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}



	

}
