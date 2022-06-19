--CODIGOS SQL Y PS/SQL PARA LA REALIZACIÓN DE LA TAREA 7

--CODIGO DE ACTIVIDAD 1 
--(Los constructores, funciones y map se declaran en esta parte porque si no no se puede modificar más adelante por la integridad referencial)
CREATE TYPE MiembroEscolar AS OBJECT(
    codigo INTEGER,
    dni VARCHAR2(10),
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    sexo VARCHAR2(1),
    fecha_nac DATE
    )NOT FINAL;
/
--Creamos el objeto Profesor con sus atributos propios y heredados de MiembroEscolar
CREATE TYPE Profesor UNDER MiembroEscolar(
    especialidad VARCHAR2(20),
    antiguedad INTEGER,
    MEMBER FUNCTION getNombreCompleto--Declarado para actividad 2 de la tarea
        RETURN VARCHAR2,
   CONSTRUCTOR FUNCTION Profesor (codigo INTEGER, nombre VARCHAR2, primerApellido VARCHAR2, segundoApellido VARCHAR2, especialidad VARCHAR2)
        RETURN SELF AS RESULT--Declarado para actividad 2 de la tarea
);
/
--Creamos el objeto Cursos junto con sus atributos, unos de ellos hace referencia al objeto Profesor creado anteriormente
CREATE TYPE Cursos AS OBJECT(
    codigo INTEGER,
    nombre VARCHAR2(20),
    refProfe REF Profesor,
    max_Alumn INTEGER,
    fecha_Inic DATE,
    fecha_Fin DATE,
    num_Horas INTEGER,
    MAP MEMBER FUNCTION ordenarCursos RETURN VARCHAR2--Declarado para actividad 8 de la tarea
);
/
--Creamos el objeto alumno con un único atributo propio del tipo objeto Cursos y heredará los atributos del objeto MiembroEscolar
CREATE TYPE Alumno UNDER MiembroEscolar(
    cursoAlumno CURSOS
);
/
--CODIGO DE ACTIVIDAD 2 
--Creación de método constructor del objeto Profesor
    CONSTRUCTOR FUNCTION PROFESOR (primerApellido VARCHAR2, segundoApellido VARCHAR2)
    RETURN SELF AS RESULT
/   
CREATE OR REPLACE TYPE BODY PROFESOR AS
    CONSTRUCTOR FUNCTION PROFESOR (codigo INTEGER, nombre VARCHAR2, primerApellido VARCHAR2, segundoApellido VARCHAR2, especialidad VARCHAR2)
        RETURN SELF AS RESULT AS
    BEGIN
        SELF.codigo := codigo;
        SELF.nombre := nombre;
        SELF.apellidos :=  primerApellido || ' ' || segundoApellido;
        SELF.especialidad := especialidad;
    END;
END;
/
--CODIGO DE ACTIVIDAD 3 
MEMBER FUNCTION getNombreCompleto(apellidos VARCHAR2, nombre VARCHAR2) 
    RETURN VARCHAR2
/
CREATE OR REPLACE TYPE BODY Profesor IS 
        CONSTRUCTOR FUNCTION Profesor (codigo INTEGER, nombre VARCHAR2, primerApellido VARCHAR2, segundoApellido VARCHAR2, especialidad VARCHAR2)
        RETURN SELF AS RESULT AS
    BEGIN
        SELF.codigo := codigo;
        SELF.nombre := nombre;
        SELF.apellidos :=  primerApellido || ' ' || segundoApellido;
        SELF.especialidad := especialidad;
        RETURN;
    END;
    MEMBER FUNCTION getNombreCompleto
        RETURN VARCHAR2 AS
    BEGIN
        RETURN SELF.apellidos || ' ' || SELF.nombre;
    END;
END;
/
--CODIGO DE ACTIVIDAD 4
CREATE TABLE PROFESORADO OF PROFESOR;
/
INSERT INTO PROFESORADO VALUES (2, '51083099F', 'MARIA LUISA', 'FABRE BERDUN', 'F', '31/03/1975', 'TECNOLOGIA', 4);
/
DECLARE
    prof PROFESOR;
BEGIN
    prof := NEW PROFESOR (3, 'JAVIER', 'JIMENEZ', 'HERNANDO', 'LENGUA');
    INSERT INTO PROFESORADO VALUES(prof);
END;
/
--CODIGO DE ACTIVIDAD 5, 6 y 7 
CREATE TYPE ListaCursos IS VARRAY (10) OF CURSOS;
/
CREATE TABLE ALUMNADO OF ALUMNO;
/
DECLARE
    listaCursos1 ListaCursos;
    p_ref REF profesor;
    alu1 ALUMNO;
    alu2 ALUMNO;
    unAlumno ALUMNO;
BEGIN 
    --Parte del código de la actividad 5, creamos el array de lista cursos y le asignamos los 2 objetos curso junto sus valores
    listaCursos1 := ListaCursos();
    listaCursos1.extend;
    SELECT REF(p) INTO p_ref FROM Profesorado p WHERE p.codigo = 3;    
    listaCursos1(1) := (Cursos(1, 'Curso 1', p_ref, 20, '1/6/2011', '30/06/2011', 30));
    listaCursos1.extend;
    SELECT REF(p) INTO p_ref FROM Profesorado p WHERE p.dni = '51083099F';    
    listaCursos1(2) := (Cursos(2, 'Curso 2', p_ref, 20, '1/6/2011', '30/06/2011', 30));
    
    --Parte del código de la actividad 6, insertamos en la tabla alumnado los 2 objetos alumno junto con los atributos correspondientes
    alu1 := NEW ALUMNO(100, '76401092Z', 'MANUEL', 'SUAREZ IBAÑEZ', 'M', '30/6/1990', listaCursos1(1));
    INSERT INTO ALUMNADO VALUES(alu1);
    alu2 := NEW ALUMNO(102, '6915588V', 'MILAGROSA', 'DIAZ PEREZ', 'F', '28/10/1984', listaCursos1(2));
    INSERT INTO ALUMNADO VALUES(alu2);
    
    --Parte del código de la actividad 7, asignamos a la variable objeto el valor de la tabla con código 100, modificamos los
    --atributos del objeto y los insertamos en la tabla alumnado
    unAlumno := NEW ALUMNO (NULL,NULL,NULL,NULL,NULL,NULL,NULL);   
    SELECT VALUE(a) INTO unAlumno FROM ALUMNADO a WHERE a.CODIGO=100;
    unAlumno.codigo := 101; 
    unAlumno.cursoAlumno := listaCursos1(2); 
    INSERT INTO ALUMNADO VALUES(unAlumno);
END;
/
--CODIGO DE ACTIVIDAD 8 
CREATE OR REPLACE TYPE BODY cursos AS
    MAP MEMBER FUNCTION ordenarCursos RETURN VARCHAR2
    AS
        BEGIN
        RETURN (getNombreCompleto (profesor));
    END ordenarCursos;
END;
/