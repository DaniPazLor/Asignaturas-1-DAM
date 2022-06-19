/*EJERCICIO 2 de Tarea 2 Modificación de la tabla anterior*/

ALTER TABLE ALUMNOS ADD EDAD number (2,0);/*Nuevo atributo*/
ALTER TABLE ALUMNOS ADD CONSTRAINT alu_edad_CH CHECK (EDAD between '14' and '65'); /*Edad entre 14 y 65*/
ALTER TABLE CURSOS ADD CONSTRAINT cur_hor_CH CHECK (NUM_HORAS_TOTALES in ('30', '40', '60')); /*Numero de horas totales curso 30, 40 o 60*/
ALTER TABLE CURSOS ADD CONSTRAINT cur_alu_CH CHECK (MAX_NUM_ALUMNOS <= 15); /*Número de alumnos mayor de 15*/
ALTER TABLE ALUMNOS DROP CONSTRAINT alu_sex_CH cascade; /*Elimina la restricción 'H' o 'M' del campo sexo*/ 
ALTER TABLE PROFESORES DROP COLUMN DIRECCION_PROFESOR; /*Elimina campo Direccion de la tabla profesor*/
ALTER TABLE PROFESORES DROP CONSTRAINT pro_nif_PK cascade; /*Eliminamos la PK del DNI y creamos la nueva con nombre y apellidos para la tabla profesores*/
ALTER TABLE PROFESORES ADD CONSTRAINT pro_nom_ape_PK primary key (NOMBRE_PROFESOR, APELLIDO1_PROFESOR, APELLIDO2_PROFESOR);
RENAME PROFESORES TO TUTORES; /*Modificar nombre tabla profesores por tutores*/
DROP TABLE ALUMNOS; /*Elimina la tabla alumnos junto con las restricciones en cascada*/
CREATE USER DANIEL IDENTIFIED BY BD02; /*Creamos usuario con la contraseña DB02*/
GRANT ALL PRIVILEGES ON ACADEMIA.CURSOS TO DANIEL; /*Le damos todos los permisos de la tabla Cursos*/ 
REVOKE UPDATE, ALTER ON ACADEMIA.CURSOS FROM DANIEL; /*Le quitamos permisos para actualizar o modificar tabla datos*/