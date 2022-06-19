create or replace TYPE tipo_persona AS OBJECT
(
 ddi VARCHAR2(10),
 nombre VARCHAR2(20),
 apellidos VARCHAR2 (40),
 MEMBER FUNCTION getNombreYApellidos RETURN VARCHAR2
) NOT FINAL;
/
CREATE TYPE BODY tipo_persona AS 
	MEMBER FUNCTION getNombreYApellidos RETURN VARCHAR2 IS
	BEGIN
		RETURN apellidos || ', ' || nombre;
	END;
END;
/
create or replace TYPE tipo_direccion AS OBJECT
(
 tipovia VARCHAR2(10), 
 nombrevia VARCHAR2(20),
 numero INTEGER,
 dirinterior VARCHAR2(30),
 codigopostal CHAR(5),
 localidad VARCHAR(20),
 provincia VARCHAR(20),
 region VARCHAR(20),
 pais VARCHAR(15)
);
/
create or replace TYPE tipo_telefono AS object (
tipo varchar2(10),
numero varchar2(30)
);
/
create or replace TYPE tabla_telefonos AS TABLE OF tipo_telefono;
/
CREATE OR REPLACE TYPE array_mails AS VARRAY(5) OF VARCHAR(40);
/
CREATE OR REPLACE TYPE tipo_conductor UNDER tipo_persona
( 
  fecha_nacimiento DATE,
  mails array_mails,
  telefonos tabla_telefonos,
  puntos_carnet INTEGER,
  direccion tipo_direccion,
  MEMBER FUNCTION edad RETURN INTEGER  
);
/
CREATE TYPE BODY tipo_conductor AS 
  MEMBER FUNCTION edad RETURN INTEGER IS
        v_edad INTEGER := 0;
  BEGIN
        v_edad := FLOOR(MONTHS_BETWEEN(CURRENT_DATE(),fecha_nacimiento)/12);
        RETURN v_edad;
  END;
END;
/

CREATE TABLE conductores OF tipo_conductor
	(CONSTRAINT ddi_c PRIMARY KEY (ddi), 
	CHECK (nombre IS NOT NULL AND
	       apellidos IS NOT NULL AND
	       fecha_nacimiento IS NOT NULL AND
	        ( puntos_carnet IS NULL 
		  OR 
                  (puntos_carnet IS NOT NULL AND puntos_carnet>=0 AND puntos_carnet<16)
                )
	      )
        )  NESTED TABLE telefonos STORE AS telefonos_ntt ;