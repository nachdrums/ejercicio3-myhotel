package com.prueba.geeks.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "EMPLOYEE", schema = "public")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String nombre;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String apellido;
	
	@Column(name = "EMAIL", nullable = false)
	private String correoElectronico;
	
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String numeroTelefonico;
	
	@Column(name = "HIRE_DATE", nullable = false)
	private Date fechaContratacion;
	
	@Column(name = "LOCACION_ID")
	private Locacion locacion;
	
	@Column(name = "MANAGER_ID")
	@JsonIgnore
	private Empleado gerente;

	


	

}
