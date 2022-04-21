package com.prueba.geeks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jobs", schema = "public")
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "JOB_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "JOB_NAME", nullable = false)
	private String nombre;

	@Column(name = "MIN_SALARY", nullable = false)
	private Float salarioMinimo;
	
	@Column(name = "MAX_SALARY", nullable = false)
	private Float salarioMaximo;

	public Cargo(Long id, String nombre, Float salarioMinimo, Float salarioMaximo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
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

	public Float getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(Float salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Float getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(Float salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	
}
