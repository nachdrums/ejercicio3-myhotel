package com.prueba.geeks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.geeks.model.Empleado;

public interface InformeDao extends CrudRepository<Empleado, Long> {

	@Query(value= "SELECT CONCAT('Mayor o igual USD ', :parametro) Segmento, COUNT(EMPLOYEE_ID) Cantidad FROM employees  "
			   + "    WHERE SALARY  >= :parametro ",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoMayorA(@Param("parametro") Long mayorA);
	
	@Query(value= "SELECT CONCAT('Menor a USD ', :parametro) Segmento, COUNT(EMPLOYEE_ID) Cantidad FROM employees  "
			   + "    WHERE SALARY < :parametro ",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoMenorA(@Param("parametro") Long menorA);
	
	@Query(value= "SELECT CONCAT('Mayor o igual USD ', :parametro1, ' y  menor que USD ', :parametro2 ) Segmento, COUNT(EMPLOYEE_ID) Cantidad FROM employees  "
			   + "    WHERE SALARY  BETWEEN :parametro1 AND :parametro2 ",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoEntre(@Param("parametro1") Long mayorA,@Param("parametro2") Long menorA);
	
	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento, CONCAT('Mayor o igual USD ', :parametro) Segmento, COUNT(COALESCE(e.EMPLOYEE_ID,null)) Cantidad FROM departments d \r\n"
			+ "LEFT JOIN employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID AND e.SALARY < :parametro\r\n"
			+ "GROUP BY d.DEPARTMENT_ID",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoAndDepartamentoMenorA(@Param("parametro") Long menorA);
	
	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento,CONCAT('Mayor o igual USD ', :parametro) Segmento, COUNT(COALESCE(e.EMPLOYEE_ID,null)) Cantidad FROM departments d \r\n"
			+ "LEFT JOIN employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID AND e.SALARY >= :parametro \r\n"
			+ "GROUP BY d.DEPARTMENT_ID \r\n"
			+ "",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoAndDepartamentoMayorA(@Param("parametro") Long mayorA);
	
	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento,CONCAT('Mayor o igual USD ', :parametro1, ' y  menor que USD ', :parametro2 ) Segmento, COUNT(COALESCE(e.EMPLOYEE_ID,null)) Cantidad FROM departments d \r\n"
			+ "LEFT JOIN employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID AND e.SALARY BETWEEN :parametro1 AND  :parametro2\r\n"
			+ "GROUP BY d.DEPARTMENT_ID ",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoAndDepartamentoEntre(@Param("parametro1") Long mayorA,@Param("parametro2") Long menorA);
	
	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento, CONCAT(e.FIRST_NAME,\" \",e.LAST_NAME) empleado, MAX(e.SALARY) Salario  FROM employees e \r\n"
			+ "INNER JOIN departments d ON d.DEPARTMENT_ID = e.DEPARTMENT_ID \r\n"
			+ "GROUP BY d.DEPARTMENT_ID \r\n"
			+ "",nativeQuery= true)
	Object[][] findCantidadEmpleadosBySegmentoAndDepartamento();

	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento, CONCAT(e.FIRST_NAME,\" \",e.LAST_NAME) empleado, MAX(e.SALARY) Salario  FROM employees e \r\n"
			+ "INNER JOIN departments d ON d.DEPARTMENT_ID = e.DEPARTMENT_ID \r\n"
			+ "GROUP BY d.DEPARTMENT_ID \r\n"
			+ "",nativeQuery= true)
	Object[][] findEmpleadoMayorSalarioByDepartamento();
	
	@Query(value= "SELECT CONCAT(e.FIRST_NAME,\" \",e.LAST_NAME) Gerente, j.JOB_TITLE Puesto, e.HIRE_DATE Fecha_Contratacion FROM employees e \r\n"
			+ "INNER JOIN jobs j on j.JOB_ID = e.JOB_ID \r\n"
			+ "WHERE j.JOB_TITLE like '%Manager%' and e.HIRE_DATE < date_add(current_date () , interval -:parametro year)",nativeQuery= true)
	Object[][] findGerentesContratadorByPeriodo(@Param("parametro") Long periodo);
	
	@Query(value= "SELECT d.DEPARTMENT_NAME Departamento, AVG(COALESCE(e.SALARY,NULL)) Promedio_Salario, COUNT(COALESCE(e.EMPLOYEE_ID,null)) Cantidad_Empleados FROM departments d \r\n"
			+ "INNER JOIN employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID \r\n"
			+ "WHERE (SELECT count(e2.EMPLOYEE_ID) FROM employees e2 WHERE e2.DEPARTMENT_ID = d.DEPARTMENT_ID  ) > :parametro\r\n"
			+ "GROUP BY d.DEPARTMENT_ID ",nativeQuery= true)
	Object[][] findSalarioPromedioByDepartamentoAndCantidadEmpleado(@Param("parametro") Long numero);
	
	@Query(value= "SELECT c.COUNTRY_NAME Pais, COUNT(COALESCE(e.EMPLOYEE_ID,null)) Cantidad_Empleados, COALESCE(MAX(COALESCE(e.SALARY,null)),0) Salario_Mas_Alto,  \r\n"
			+ "COALESCE(MIN(COALESCE(e.SALARY,null)),0) Salario_Mas_Bajo, COALESCE(ROUND(AVG(COALESCE(TIMESTAMPDIFF(YEAR,e.HIRE_DATE ,CURDATE()),null))),0) Antiguedad_Promedio \r\n"
			+ "FROM countries c \r\n"
			+ "LEFT JOIN locations l ON l.COUNTRY_ID = c.COUNTRY_ID \r\n"
			+ "LEFT JOIN departments d ON d.LOCATION_ID  = l.LOCATION_ID \r\n"
			+ "LEFT JOIN employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID \r\n"
			+ "GROUP BY  c.COUNTRY_ID ",nativeQuery= true)
	Object[][] findCantidadEmpleadosSalarioPromedioSalarioBajoSalarioAltoPromedioAniosAntiguedadByPais();
}
