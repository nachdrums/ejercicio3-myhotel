package com.prueba.geeks.service;

import java.util.List;

import com.prueba.geeks.dto.Ejercicio1DTO;
import com.prueba.geeks.dto.Ejercicio2DTO;
import com.prueba.geeks.dto.Ejercicio3DTO;
import com.prueba.geeks.dto.Ejercicio4DTO;
import com.prueba.geeks.dto.Ejercicio5DTO;
import com.prueba.geeks.dto.Ejercicio6DTO;
import com.prueba.geeks.dto.SegmentoDTO;

public interface InformeService {
	
	
	public List<Ejercicio1DTO> findCantidadEmpleadosBySegmento(SegmentoDTO segmento);

	public List<Ejercicio2DTO> findCantidadEmpleadosBySegmentoAndDepartamento(SegmentoDTO segmento);
	
	public List<Ejercicio3DTO> findEmpleadoMayorSalarioByDepartamento();
	
	public List<Ejercicio4DTO> findGerentesContratadorByPeriodo(Long periodo);
	
	public List<Ejercicio5DTO> findSalarioPromedioByDepartamentoAndCantidadEmpleado(Long cantidad);
	
	public List<Ejercicio6DTO> findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais();
}
