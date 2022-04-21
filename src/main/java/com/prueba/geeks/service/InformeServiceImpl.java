package com.prueba.geeks.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.geeks.dto.Ejercicio1DTO;
import com.prueba.geeks.dto.Ejercicio2DTO;
import com.prueba.geeks.dto.Ejercicio3DTO;
import com.prueba.geeks.dto.Ejercicio4DTO;
import com.prueba.geeks.dto.Ejercicio5DTO;
import com.prueba.geeks.dto.Ejercicio6DTO;
import com.prueba.geeks.dto.SegmentoDTO;
import com.prueba.geeks.dto.VehiculoDTO;
import com.prueba.geeks.repository.InformeDao;

@Service
public class InformeServiceImpl implements InformeService {
	private static final Logger logger = LoggerFactory.getLogger(InformeServiceImpl.class);

	@Autowired
	private InformeDao informeDao;

	@Transactional
	public List<Ejercicio1DTO> findCantidadEmpleadosBySegmento(SegmentoDTO segmento) {
		
		
		Object[][] lista;
		
		switch (segmento.getTipoSegmento().toUpperCase()) 
        {
            case "A":  lista = informeDao.findCantidadEmpleadosBySegmentoMenorA(segmento.valorMenorA);
                     break;
            case "B":  lista = informeDao.findCantidadEmpleadosBySegmentoEntre(segmento.valorMayorA, segmento.valorMenorA);
                     break;
            case "C":  lista = informeDao.findCantidadEmpleadosBySegmentoMayorA(segmento.valorMayorA);
                     break;
            default: lista =null;
                     break;
        }
		
		List<Ejercicio1DTO> listaEjercicio = new ArrayList<Ejercicio1DTO>();
		for(Object[] obj: lista) {
			Ejercicio1DTO eje = new Ejercicio1DTO();
			eje.setSegmento(obj[0].toString());
			eje.setCantidad(((BigInteger)obj[1]).longValue());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	
	
	@Transactional
	public List<Ejercicio2DTO> findCantidadEmpleadosBySegmentoAndDepartamento(SegmentoDTO segmento) {
		
		
		Object[][] lista;
		
		switch (segmento.getTipoSegmento().toUpperCase()) 
        {
            case "A":  lista = informeDao.findCantidadEmpleadosBySegmentoAndDepartamentoMenorA(segmento.valorMenorA);
                     break;
            case "B":  lista = informeDao.findCantidadEmpleadosBySegmentoAndDepartamentoEntre(segmento.valorMayorA, segmento.valorMenorA);
                     break;
            case "C":  lista = informeDao.findCantidadEmpleadosBySegmentoAndDepartamentoMayorA(segmento.valorMayorA);
                     break;
            default: lista =null;
                     break;
        }
		
		List<Ejercicio2DTO> listaEjercicio = new ArrayList<Ejercicio2DTO>();
		for(Object[] obj: lista) {
			Ejercicio2DTO eje = new Ejercicio2DTO();
			eje.setDepartamento(obj[0].toString());
			eje.setSegmento(obj[1].toString());
			eje.setCantidad(((BigInteger)obj[2]).longValue());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	
	@Transactional
	public List<Ejercicio3DTO> findCantidadEmpleadosBySegmentoAndDepartamento() {

		Object[][] lista = informeDao.findCantidadEmpleadosBySegmentoAndDepartamento();

		List<Ejercicio3DTO> listaEjercicio = new ArrayList<Ejercicio3DTO>();
		for(Object[] obj: lista) {
			Ejercicio3DTO eje = new Ejercicio3DTO();
			eje.setDepartamento(obj[0].toString());
			eje.setEmpleado(obj[1].toString());
			eje.setSalario(((BigInteger)obj[2]).longValue());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	

	
	@Transactional
	public List<Ejercicio3DTO> findEmpleadoMayorSalarioByDepartamento() {

		Object[][] lista = informeDao.findEmpleadoMayorSalarioByDepartamento();
		List<Ejercicio3DTO> listaEjercicio = new ArrayList<Ejercicio3DTO>();
		for(Object[] obj: lista) {
			Ejercicio3DTO eje = new Ejercicio3DTO();
			eje.setDepartamento(obj[0].toString());
			eje.setEmpleado(obj[1].toString());
			eje.setSalario(((BigDecimal)obj[2]).longValue());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	
	@Transactional
	public List<Ejercicio4DTO> findGerentesContratadorByPeriodo(Long periodo) {
		logger.info("[obtener lista de vehiculo]");

		Object[][] lista = informeDao.findGerentesContratadorByPeriodo(periodo);
		
		List<Ejercicio4DTO> listaEjercicio = new ArrayList<Ejercicio4DTO>();
		for(Object[] obj: lista) {
			Ejercicio4DTO eje = new Ejercicio4DTO();
			eje.setGerente(obj[0].toString());
			eje.setPuesto(obj[1].toString());
			eje.setFechaContratacion(obj[2].toString());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	
	@Transactional
	public List<Ejercicio5DTO> findSalarioPromedioByDepartamentoAndCantidadEmpleado(Long id) {
		logger.info("[obtener lista de vehiculo]");

		Object[][] lista = informeDao.findSalarioPromedioByDepartamentoAndCantidadEmpleado(id);

		List<Ejercicio5DTO> listaEjercicio = new ArrayList<Ejercicio5DTO>();
		for(Object[] obj: lista) {
			Ejercicio5DTO eje = new Ejercicio5DTO();
			eje.setDepartamento(obj[0].toString());
			eje.setPromedioSalario(obj[1].toString());
			eje.setCantidadEmpleados(((BigInteger)obj[2]).longValue());
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
	
	@Transactional
	public List<Ejercicio6DTO> findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais() {

		Object[][] lista = informeDao.findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais();

		List<Ejercicio6DTO> listaEjercicio = new ArrayList<Ejercicio6DTO>();
		for(Object[] obj: lista) {
			Ejercicio6DTO eje = new Ejercicio6DTO();
			
			eje.setPais(obj[0].toString());
			eje.setCantidadEmpleados(((BigInteger)obj[1]).longValue());
			eje.setSalarioMasAlto(((BigInteger)obj[2]).longValue());
			eje.setSalarioMasBajo(((BigInteger)obj[3]).longValue());
			eje.setAntiguedadPromedio(((BigInteger)obj[4]).longValue());
			
			
			listaEjercicio.add(eje);
		}
		
		
		return listaEjercicio;
	}
}
