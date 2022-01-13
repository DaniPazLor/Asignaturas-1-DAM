//paquete de procedimientos y funciones

CREATE OR REPLACE PACKAGE paq_bajada_sueldo AS
    PROCEDURE baja_sueldos;
    FUNCTION hubo_errores RETURN BOOLEAN;
    --constante global para el porcentaje de bajada
    porcentaje CONSTANT number := 5;
END paq_bajada_sueldo;
/

CREATE OR REPLACE PACKAGE BODY paq_bajada_sueldo AS
PROCEDURE baja_sueldos IS
	codigoE number;
	textoE VARCHAR2(64);
BEGIN
	for i IN (SELECT nif, sueldo FROM NOMINAS) LOOP
		BEGIN
			UPDATE NOMINAS SET sueldo = i.sueldo - i.sueldo * porcentaje / 100
			WHERE nif = i.nif;

			-- Excepcion para controlar posible error
			EXCEPTION
			WHEN OTHERS THEN
				codigoE := SQLCODE;
				textoE := SUBSTR(SQLERRM, 1, 64);
				INSERT INTO ERR_BAJADA_SUELDO (nif, codigoError, textoError)
				VALUES (i.nif, codigoE, textoE);
		END
		COMMIT;
	END LOOP;
END baja_sueldos;

FUNCTION hubo_errores RETURN BOOLEAN IS
	res BOOLEAN := FALSE;
	numErrores number;
BEGIN
	SELECT COUNT(*) INTO numErrores FROM ERR_BAJADA_SUELDO;
	IF numErrores>0 THEN
		res := TRUE;
	END IF;
	RETURN res;
END hubo_errores;

END paq_bajada_sueldo;
/


//llamada al procedimiento baja_sueldos y comprobacion de hubo_errores
SET SERVEROUTPUT ON

--Borrar tabla de errores
DELETE FROM ERR_BAJADA_SUELDO;

--Llamada al procedimiento de bajada de sueldos
CALL paq_bajada_sueldo.baja_sueldos();

-- Comprobar errores
BEGIN
	IF paq_bajada_sueldo.hubo_errores THEN
		FOR i IN (SELECT * FROM ERR_BAJADA_SUELDO) LOOP
			DBMS_OUTPUT.PUT_LINE('Error al actualizar el sueldo del '||'funcionario con NIF '||i.nif||'. Codigo '||i.codigoError||' y su texto: '||i.textoError);
		END LOOP;
	END IF;
END;
/