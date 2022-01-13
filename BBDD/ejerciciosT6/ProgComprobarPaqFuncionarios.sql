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
