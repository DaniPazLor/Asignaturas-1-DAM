--BLOQUE ANÓNIMO PRINCIPAL PARA COMPROBAR QUE FUNCIONA EL DISPARADOR
DECLARE
    V_USUARIO agentes.usuario%TYPE := &Usuario;
    V_CLAVE agentes.clave%TYPE := &Clave;
    V_HABILIDAD agentes.habilidad%TYPE := &Habilidad;
    V_CATEGORIA agentes.categoria%TYPE := &Categoría;
    V_FAMILIA agentes.familia%TYPE := &Familia;
    V_OFICINA agentes.oficina%TYPE := &Oficina;
BEGIN
    insert INTO AGENTES (USUARIO, CLAVE, HABILIDAD, CATEGORIA, FAMILIA, OFICINA) VALUES (V_USUARIO, V_CLAVE, V_HABILIDAD, V_CATEGORIA, V_FAMILIA, V_OFICINA);
END;
/
--DECLARACIÓN DEL DISPARADOR
CREATE OR REPLACE TRIGGER CONTROLAR_RESTRICCIONES 
BEFORE INSERT OR UPDATE ON AGENTES
FOR EACH ROW
BEGIN
     IF (:new.usuario = :new.clave) THEN
          RAISE_APPLICATION_ERROR(-20201, 'El usuario y la clave no pueden ser iguales');
     ELSIF (:new.habilidad <0 OR :new.habilidad >9) THEN
          RAISE_APPLICATION_ERROR(-20202, 'La habilidad debe estar comprendida entre 0 y 9');
     ELSIF (:new.categoria <0 OR :new.categoria >2) THEN   
        RAISE_APPLICATION_ERROR(-20203, 'La categoría de un agente debe estar comprendida entre 0 y 2');
     ELSIF (:new.oficina is not null AND :new.categoria <> 2) THEN   
        RAISE_APPLICATION_ERROR(-20204, 'La categoría de un agente que pertenece a una oficina debe ser igual a 2'); 
     ELSIF (:new.oficina is null AND :new.categoria = 2) THEN   
        RAISE_APPLICATION_ERROR(-20205, 'La categoría de un agente que no pertenece a una oficina no puede ser igual a 2');
     ELSIF (:new.oficina is null AND :new.familia is null) THEN   
        RAISE_APPLICATION_ERROR(-20206, 'Los agentes deben pertenecer a una oficina o a una familia');
         ELSIF (:new.oficina is not null AND :new.familia is not null) THEN   
        RAISE_APPLICATION_ERROR(-20207, 'Los agentes no pueden pertenecer a una oficina y a una familia a la vez');
     END IF;

END;
/