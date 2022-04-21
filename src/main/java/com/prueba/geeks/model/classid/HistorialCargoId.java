package com.prueba.geeks.model.classid;


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.prueba.geeks.model.Empleado;


public class HistorialCargoId implements Serializable {
	
    private Empleado empleado;

    private Date fechaInicio;

    // default constructor

    public HistorialCargoId(Empleado empleado, Date fechaInicio) {
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
    }

	@Override
	public int hashCode() {
		return Objects.hash(empleado, fechaInicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistorialCargoId other = (HistorialCargoId) obj;
		return Objects.equals(empleado, other.empleado) && Objects.equals(fechaInicio, other.fechaInicio);
	}

    
}