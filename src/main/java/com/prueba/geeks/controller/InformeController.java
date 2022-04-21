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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/informe")
public class InformeController {

	private ResponseAPI response= new ResponseAPI();
	
	@Autowired
	private InformeService informeService;


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
	
	@GetMapping(value = "/get/ejercicio3")
	public ResponseEntity<?> listEjercicio3() {
		
		List<Ejercicio3DTO> list = informeService.findEmpleadoMayorSalarioByDepartamento();
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@GetMapping(value = "/get/ejercicio4")
	public ResponseEntity<?> listEjercicio4(@RequestParam(value ="antiguedad") long antiguedad) {
		
		List<Ejercicio4DTO> list= informeService.findGerentesContratadorByPeriodo(antiguedad);
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@GetMapping(value = "/get/ejercicio5")
	public ResponseEntity<?> listEjercicio5(@RequestParam(value ="cantidad") long cantidad) {
		
		List<Ejercicio5DTO> list = informeService.findSalarioPromedioByDepartamentoAndCantidadEmpleado(cantidad);
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}
	
	@GetMapping(value = "/get/ejercicio6")
	public ResponseEntity<?> listEjercicio6() {
		
		List<Ejercicio6DTO> list = informeService.findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais();
		this.response.setData((Object) list);
		this.response.setMessage("operación realizada exitosamente");
		this.response.setSuccess(true);
		return new ResponseEntity<ResponseAPI>(this.response, HttpStatus.OK);

	}

}

