/*Creamos las tablas y los nombres de los campos con sus correspondientes titulos*/
CREATE TABLE ALUMNOS (
    NOMBRE_ALUMNO varchar2 (20),
    APELLIDO1_ALUMNO varchar2 (30),
    APELLIDO2_ALUMNO varchar2 (30),
    NIF_ALUMNO varchar2 (9),
    DIRECCION_ALUMNO varchar2 (50),
    SEXO varchar2 (1),
    FECHA_NACIMIENTO date,
    CODIGO_CURSO number (10,0));
CREATE TABLE CURSOS (
    NOMBRE_CURSO varchar2 (50),
    CODIGO number (10,0),
    NIF_PROFESOR varchar2 (9),
    MAX_NUM_ALUMNOS number (2,0),
    FECHA_INICIO date,
    FECHA_FINAL date,
    NUM_HORAS_TOTALES number (4,0));
CREATE TABLE PROFESORES (
    NOMBRE_PROFESOR varchar2 (30),
    APELLIDO1_PROFESOR varchar2 (40),
    APELLIDO2_PROFESOR varchar2 (40),
    NIF_PROFESOR varchar2 (9),
    DIRECCION_PROFESOR varchar2 (50),
    TITULACION varchar2 (50),
    SALARIO number (6,2));

/*Metemos las restricciones del ejercicio 1 a las tablas correspondientes*/

/*Referenciamos el codigo de la tabla cursos y lo hacemos obligatorio para dar de alta alumno*/
ALTER TABLE ALUMNOS MODIFY CODIGO_CURSO CONSTRAINT alu_cod_FK REFERENCES CURSOS NOT NULL;
ALTER TABLE CURSOS MODIFY NUM_HORAS_TOTALES CONSTRAINT cur_num_NN NOT NULL;/*Campo obligatorio*/
ALTER TABLE PROFESORES MODIFY SALARIO CONSTRAINT pro_sal_NN NOT NULL;/*Campo obligatorio*/
ALTER TABLE CURSOS MODIFY NOMBRE_CURSO CONSTRAINT cur_nom_UN UNIQUE;/*Campo único*/
ALTER TABLE PROFESORES ADD CONSTRAINT pro_nom_UN UNIQUE (NOMBRE_PROFESOR);/*Campo único*/
ALTER TABLE CURSOS MODIFY CODIGO_CURSO CONSTRAINT cur_cod_PK PRIMARY KEY;/*Campo clave o índice tabla CURSOS*/
ALTER TABLE PROFESORES MODIFY NIF_PROFESOR CONSTRAINT pro_nif_PK PRIMARY KEY;/*Campo clave o índice tabla PROFESORES*/
ALTER TABLE ALUMNOS MODIFY NIF_ALUMNO CONSTRAINT alu_nif_PK PRIMARY KEY;/*Campo clave o índice tabla ALUMNOS*/
ALTER TABLE CURSOS ADD CONSTRAINT cur_fec_CH CHECK (FECHA_INICIO < FECHA_FINAL);/*Condicion fechafin < fechafinal*/
ALTER TABLE ALUMNOS ADD CONSTRAINT alu_sex_CH CHECK (SEXO IN ('H','M'));/*Condición letra H o M*/

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