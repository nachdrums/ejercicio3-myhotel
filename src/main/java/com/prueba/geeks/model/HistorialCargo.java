package com.prueba.geeks.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.prueba.geeks.model.classid.HistorialCargoId;


@Entity
@Table(name = "job_history", schema = "public")
@IdClass(HistorialCargoId.class)
public class HistorialCargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
	@ManyToOne(optional = true)
	private Empleado empleado;
	
	@Id
	@Column(name = "START_DATE", nullable = false)
	private Date fechaInicio;
	
	@Column(name = "END_DATE", nullable = false)
	private Date fechaFin;

	@Column(name = "JOB_ID")
	private Cargo cargo;
	
	@Column(name = "DEPARTAMENT_ID")
	private Departamento departamento;

	public HistorialCargo(Empleado empleado, Date fechaInicio, Date fechaFin, Cargo cargo, Departamento departamento) {
		super();
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	
}
