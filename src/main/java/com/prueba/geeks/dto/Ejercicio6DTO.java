package com.prueba.geeks.dto;

public class Ejercicio6DTO {

	public String Pais;
	
	public Long cantidadEmpleados;
	
	public Long salarioMasAlto;
	
	public Long salarioMasBajo;
	
	public Long antiguedadPromedio;

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public Long getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(Long cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public Long getSalarioMasAlto() {
		return salarioMasAlto;
	}

	public void setSalarioMasAlto(Long salarioMasAlto) {
		this.salarioMasAlto = salarioMasAlto;
	}

	public Long getSalarioMasBajo() {
		return salarioMasBajo;
	}

	public void setSalarioMasBajo(Long salarioMasBajo) {
		this.salarioMasBajo = salarioMasBajo;
	}

	public Long getAntiguedadPromedio() {
		return antiguedadPromedio;
	}

	public void setAntiguedadPromedio(Long antiguedadPromedio) {
		this.antiguedadPromedio = antiguedadPromedio;
	}

	
}
