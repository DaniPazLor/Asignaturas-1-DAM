--Creacion tabla clientes
CREATE TABLE Clientes (
    Cod_cliente INTEGER,
    Nombre VARCHAR2(20),
    Telefono VARCHAR2(10),
    CONSTRAINT con_cli_pk PRIMARY KEY (Cod_Cliente) 
);

CREATE SEQUENCE cliente_seq START WITH 1;

CREATE OR REPLACE TRIGGER clientes_bir 
BEFORE INSERT ON clientes 
FOR EACH ROW

BEGIN
  SELECT cliente_seq.NEXTVAL
  INTO   :new.Cod_cliente
  FROM   dual;
END;
/
--Crear la tabla escrituras
CREATE TABLE Escrituras (
    Cod_Escritura VARCHAR2(10),
    codCli INTEGER,
    Tipo VARCHAR2(10),
    Nom_fich VARCHAR2(80),
    Num_interv INTEGER,
    CONSTRAINT codEsc_pk PRIMARY KEY (Cod_Escritura),
    CONSTRAINT codCl_FK FOREIGN KEY (codCli) REFERENCES Clientes(cod_cliente)
);
/
CREATE SEQUENCE esc_seq START WITH 1;

CREATE OR REPLACE TRIGGER esc_bir 
BEFORE INSERT ON escrituras 
FOR EACH ROW
BEGIN
  SELECT escrituras_seq.NEXTVAL
  INTO   :new.Cod_Escritura
  FROM   dual;
END;
/
CREATE TABLE EscCli (
    codEscCli INTEGER,
    codCli INTEGER,
    CodEsc INTEGER,
    CONSTRAINT codCl_FK FOREIGN KEY (codCli) REFERENCES Clientes(cod_cliente),
    CONSTRAINT CodEs_FK FOREIGN KEY (CodEsc) REFERENCES Escrituras(Cod_Escritura),
    CONSTRAINT codEC_PK PRIMARY KEY (codEscCli,codCli, CodEsc)
);
CREATE SEQUENCE escCli_seq START WITH 1;

CREATE OR REPLACE TRIGGER esCli_bir 
BEFORE INSERT ON EscCli 
FOR EACH ROW

BEGIN
  SELECT escCli_seq.NEXTVAL
  INTO   :new.codEscCli
  FROM   dual;
END;
/
INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES ( 'Julio', '670393815');
/
INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES ('Maria', '692237541');
/
INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES ('ES128596', 1, 'CPVE', 'compraventa_Julio_02_12_2018.doc', 3);
/
INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES ('E135896', 2, 'TEST', 'testamento_Maria_04_10_2000.doc', 6);
/
INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES ('E165456', 3, 'CPVE', 'compraventa_Daniel_14_11_2005.doc', 8);
/
SELECT * FROM Clientes c INNER JOIN esccli e ON c.cod_cliente=e.codcli INNER JOIN escrituras es ON e.codesc=es.cod_escritura ;--WHERE es.tipo='CPVE'
/
SELECT c.nombre, es.tipo FROM Clientes c INNER JOIN escrituras es ON c.cod_cliente=es.codcli WHERE es.tipo='CPVE';
/
SELECT * FROM clientes c, escrituras e WHERE c.cod_cliente=e.cod_cli;
/
SELECT * FROM clientes;
/
UPDATE clientes SET nombre='Pepe', telefono='680256430' WHERE cod_cliente=21;