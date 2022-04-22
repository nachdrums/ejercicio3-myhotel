package com.prueba.geeks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.geeks.dto.Ejercicio1DTO;
import com.prueba.geeks.dto.Ejercicio2DTO;
import com.prueba.geeks.dto.Ejercicio3DTO;
import com.prueba.geeks.dto.Ejercicio4DTO;
import com.prueba.geeks.dto.Ejercicio5DTO;
import com.prueba.geeks.dto.Ejercicio6DTO;
import com.prueba.geeks.dto.ResponseAPI;
import com.prueba.geeks.dto.SegmentoDTO;
import com.prueba.geeks.service.InformeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/informe")
public class InformeController {

	private ResponseAPI response= new ResponseAPI();
	
	@Autowired
	private InformeService informeService;

	@ApiOperation(
	        value = "Obtener cantidad de empleados dentro de los siguientes segmentos de "
	        		+ "sueldo: <br />"
	        		+ " SEGMENTO A: menor a USD 3.500,"
	        		+ " SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000,"
	        		+ " SEGMENTO C: mayor o igual a USD 8.000.",
	        notes = "Retorna 404 si no ha retornado nada" )
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio1")
	public ResponseEntity<?> getEjercicio1(@RequestParam(value ="segmento") String tipoSegmento, 
			@RequestParam(value ="mayorA", required=false, defaultValue = "0") long mayorA,
			@RequestParam(value ="menorA", required=false, defaultValue = "0") long menorA) {
		
		SegmentoDTO segmento =new SegmentoDTO();
		segmento.setTipoSegmento(tipoSegmento);
		segmento.setValorMayorA(mayorA);
		segmento.setValorMenorA(menorA);
		
		List<Ejercicio1DTO> list = informeService.findCantidadEmpleadosBySegmento(segmento);
		
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@ApiOperation(
	        value = "Utilizando la tabla “departments” se requiere realizar la misma agrupación \r\n"
	        		+ "de segmentos de sueldo, pero por departamento: \r\n"
	        		+ "  SEGMENTO A: menor a USD 3.500,\r\n"
	        		+ "  SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000,\r\n"
	        		+ "  SEGMENTO C: mayor o igual a USD 8.000.",
	        notes = "Retorna 404 si no ha retornado nada")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio2")
	public ResponseEntity<?> getEjercicio2(@RequestParam(value ="segmento") String tipoSegmento, 
			@RequestParam(value ="mayorA", required=false, defaultValue = "0") long mayorA,
			@RequestParam(value ="menorA", required=false, defaultValue = "0") long menorA) {
		
		SegmentoDTO segmento =new SegmentoDTO();
		segmento.setTipoSegmento(tipoSegmento);
		segmento.setValorMayorA(mayorA);
		segmento.setValorMenorA(menorA);
		
		List<Ejercicio2DTO> list = informeService.findCantidadEmpleadosBySegmentoAndDepartamento(segmento);
		
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@ApiOperation(
	        value = "Información del empleado con mayor sueldo de cada departamento.",
	        notes = "Retorna 404 si no ha retornado nada")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio3")
	public ResponseEntity<?> listEjercicio3() {
		
		List<Ejercicio3DTO> list = informeService.findEmpleadoMayorSalarioByDepartamento();
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@ApiOperation(
	        value = "Información de los gerentes que hayan sido contratados hace más de 15\r\n"
	        		+ "años.",
	        notes = "Retorna 404 si no ha retornado nada")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio4")
	public ResponseEntity<?> listEjercicio4(@RequestParam(value ="antiguedad") long antiguedad) {
		
		List<Ejercicio4DTO> list= informeService.findGerentesContratadorByPeriodo(antiguedad);
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@ApiOperation(
	        value = "Salario promedio de todos los departamentos que tengan más de 10\r\n"
	        		+ "empleados.\r\n",
	        notes = "Retorna 404 si no ha retornado nada")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio5")
	public ResponseEntity<?> listEjercicio5(@RequestParam(value ="cantidad") long cantidad) {
		
		List<Ejercicio5DTO> list = informeService.findSalarioPromedioByDepartamentoAndCantidadEmpleado(cantidad);
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@ApiOperation(
	        value = "Obtener la siguiente información agrupada por país: cantidad empleados,\r\n"
	        		+ "salario promedio, salario más alto, salario más bajo, promedio años\r\n"
	        		+ "antigüedad\r\n",
	        notes = "Retorna 404 si no ha retornado nada")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Registro encontrado"),
	        @ApiResponse(code = 404, message = "Registro no encontrado")})
	@GetMapping(value = "/get/ejercicio6")
	public ResponseEntity<?> listEjercicio6() {
		
		List<Ejercicio6DTO> list = informeService.findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais();
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}

}

