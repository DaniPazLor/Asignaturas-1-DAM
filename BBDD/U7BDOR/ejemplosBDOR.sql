--ejemplos tipos y tablas objeto relacionales

CREATE OR REPLACE TYPE tipo_direccion AS OBJECT
(dir VARCHAR2(100), cp NUMBER(5))
/

CREATE OR REPLACE TYPE tipo_contacto AS OBJECT
(telefono NUMBER(9), email VARCHAR(30))
/

CREATE OR REPLACE TYPE tipo_persona AS OBJECT
(id VARCHAR2(20),
 nombre VARCHAR2(30),
 apellido VARCHAR2(30),
 direccion tipo_direccion,
 contacto tipo_contacto)
not final
/

CREATE OR REPLACE type tipo_cliente UNDER tipo_persona
(n_pedidos NUMBER)
/

CREATE OR REPLACE type tipo_articulo AS OBJECT(
  id_art NUMBER(5),
  nombre VARCHAR2(30),
  descripcion VARCHAR2(100),
  precio NUMBER(6),
  porct_iva NUMBER(2)
)
/

CREATE OR REPLACE type tabla_articulos AS 
TABLE OF tipo_articulo;
/

CREATE OR REPLACE type tipo_lista_detalle AS OBJECT(
 numero NUMBER,
 articulo tipo_articulo,
 cantidad NUMBER
);
/

CREATE OR REPLACE type tab_lista_detalle AS 
TABLE OF tipo_lista_detalle;
/

CREATE OR REPLACE type tipo_lista_compra AS OBJECT
(id NUMBER,
 fecha DATE,
 cli REF tipo_cliente,
 detalle tab_lista_detalle,
 MEMBER FUNCTION total 
 RETURN NUMBER
);
/

CREATE OR REPLACE type body tipo_lista_compra AS 
MEMBER FUNCTION total
RETURN NUMBER IS
	i integer;
tot NUMBER:=0;
BEGIN
	FOR i IN 1..detalle.count LOOP
Tot:=tot+(detalle(i).cantidad*detalle(i).articulo.precio)* (1+(detalle(i).articulo.porct_iva/100));
	END LOOP;
RETURN tot;
	END;
END;
/

CREATE TABLE clientes of tipo_cliente;
INSERT INTO clientes 
VALUES (1, ’Maria’,’Suarez’, tipo_direccion(‘C/ Mayor 2’,’34001’),
		tipo_contacto(‘979666555’,’mariasuarez@gmail.com’), 0);


CREATE TABLE listas_de_compras OF tipo_lista_compra 
NESTED TABLE detalle STORE AS tdetalle;

INSERT INTO listas_de_compras
SELECT 1,current_date, ref(c), tab_lista_detalle(
tipo_lista_detalle(1,tipo_articulo(1,’Barra de pan’,’Tipo baguette’,1,7),4),
tipo_lista_detalle(2,tipo_articulo(2,’Jamon’,’Iberico’,6,7),4))
FROM clientes c
WHERE c.id=1;



SELECT id,fecha,deref(cli) AS cliente, detalle
FROM listas_de_compras;

SELECT id, c.total()q
FROM listas_de_compras c;

