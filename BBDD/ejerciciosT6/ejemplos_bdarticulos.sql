SET SERVEROUTPUT ON
--Permite usar el paquete de imprimir en pantalla
DECLARE
	contador number(5):=0;--variable cuenta las filas
BEGIN
	SELECT COUNT(*) INTO contador FROM FABRICANTE;
	--Contamos las filas de FABRICANTE
	DBMS_OUTPUT.PUT_LINE('El numero de filas de FABRICANTE es:'
	 || contador);
END;
/

SET SERVEROUTPUT ON
--PROCEDIMIENTO para comprobar si hay articulos de BQ
DECLARE
	contador number(5);	
BEGIN
	contador:=0;
	SELECT COUNT(*) INTO contador
	FROM ARTICULO A, FABRICANTE F
	WHERE (A.CodFab=F.CodFab AND NomFab='BQ');
	IF (contador>0)	THEN
		DBMS_OUTPUT.PUT_LINE('Hay: ' || contador || ' productos de BQ');
		ELSE
			DBMS_OUTPUT.PUT_LINE('No hay: productos de BQ');
	END IF;
END;
/

-- INSERCION DE ARTICULO

BEGIN
	INSERT INTO ARTICULO
	VALUES ('0000000011','Tablet',350,'0000000017');
END;
/

-- uso del elsif
-- precios: tipo1 hasta 200€, tipo 2 hasta 400, t3 hasta 1000,t4
DECLARE
	precioArt number(6,2):=0;
	codarti varchar2(10):=&art;
BEGIN	
	SELECT Precio INTO precioArt
	FROM ARTICULO A
	WHERE (CodArt=codarti);
	IF (precioArt<=200) THEN
		DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		ELSIF (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
			ELSIF (precioArt <=1000) THEN
				DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
				ELSE
					DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END IF;
END;
/


-- uso del elsif
DECLARE
	precioArt number(6,2);
BEGIN
	precioArt:=0;
	SELECT A.Precio INTO precioArt
	FROM ARTICULO A
	WHERE (A.CodArt='0000000001');
	IF (precioArt<=200) THEN
		DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		ELSIF (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
			ELSIF (precioArt <=1000) THEN
				DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
				ELSE
					DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END IF;
END;
/

--Pedir datos de usuario
DECLARE
	PrecioUsr number(6,2):=&pre;	
BEGIN
	DBMS_OUTPUT.PUT_LINE('Introduce un precio: ' || precioUsr);
	DBMS_OUTPUT.PUT_LINE('El precio introducido es: ' || precioUsr);
END;
/	

BEGIN
	DBMS_OUTPUT.PUT_LINE('Introduce un precio: ' || &pre);
END;
/	

-- uso del case
-- precios: tipo1 hasta 200€, tipo 2 hasta 400, t3 hasta 1000,t4
DECLARE
	precioArt number(6,2):=0;
	codarti varchar2(10):=&art;
BEGIN	
	SELECT Precio INTO precioArt
	FROM ARTICULO A
	WHERE (CodArt=codarti);
	case
		WHEN (precioArt<=200) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 1.');
		WHEN (precioArt<=400) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 2.');
		WHEN (precioArt <=1000) THEN
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 3');
		ELSE
			DBMS_OUTPUT.PUT_LINE('El precio ' || precioArt || ' es de tipo 4');
	END case;
END;
/

--bucle con condicion al final
DECLARE
	contador number(6);
	num number(6);
BEGIN
	contador:=1;
	num:=&numero;
	LOOP				
		DBMS_OUTPUT.PUT_LINE('Contando: '|| contador);
		contador:=contador+1;
		EXIT WHEN (contador>num);
	END LOOP;
END;
/

--bucle con condicion al principio
DECLARE
	contador number(6);
	num number(6);
BEGIN
	contador:=1;
	num:=&numero;	
	WHILE (contador<=num) LOOP
		DBMS_OUTPUT.PUT_LINE('Contando: '|| contador);
		contador:=contador+1;
	END LOOP;
END;
/