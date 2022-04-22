# Prueba myHotel Ejercicio 1



## Descripción del proyecto

El proyecto tiene como fin construir una aplicación en Spring Boot para resolver los siguientes problemas:

- i. Obtener cantidad de empleados dentro de los siguientes segmentos de
sueldo:
SEGMENTO A: menor a USD 3.500
SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000
SEGMENTO C: mayor o igual a USD 8.000.

- ii. Utilizando la tabla “departments” se requiere realizar la misma agrupación
de segmentos de sueldo, pero por departamento.

- iii. Información del empleado con mayor sueldo de cada departamento.

- iv. Información de los gerentes que hayan sido contratados hace más de 15
años.

- v. Salario promedio de todos los departamentos que tengan más de 10
empleados.

- vi. Obtener la siguiente información agrupada por país: cantidad empleados,
salario promedio, salario más alto, salario más bajo, promedio años
antigüeda

## Configuración de ambiente

- Clone el repositorio en su carpeta de destino.
- Ingrese a su IDE e importe el proyecto a su workspace, para este caso se utilizó la Spring Tool Suite 4 de eclipse.
- Luego en la pestaña Boot Dashboard haga clic derecho en el proyecto y seleccione la opción "(Re)start"
![image](https://user-images.githubusercontent.com/19580361/164142856-6d56561f-3e26-4a96-bc1b-efe1f4b1ec85.png)


## Base de datos
- La base de datos MySQL que se utilizó, se generó con el backup que se encuentra en el documento "Enunciado Prueba Técnica BackEnd.pdf" 
- La configuración de la base de datos se encuentra en el archivo aplication.properties del proyecto, para este caso se utilizo lo siguiente:
  - Nombre base de datos: myhotel.
  - Usuario: root.
  - Contraseña: admin1234
- La configuración la deben cambiar de acuerdo a lo usted estime conveniente.


## Endpoints

Para los endpoints de la aplicación se ha usado la herramienta llamada Swagger, para ingresar a la herramienta ingrese al siguiente link:
```
http://localhost:8080/api-prueba/swagger-ui.html#/
```
- La herramienta muestra por cada controlador los endpoints junto con su descripción y parámetros.


