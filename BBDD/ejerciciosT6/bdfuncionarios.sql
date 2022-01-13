CREATE TABLE NOMINAS(
nif VARCHAR2(9) NOT NULL,
sueldo number(8,2) NOT NULL
);

CREATE TABLE ERR_BAJADA_SUELDO(
nif VARCHAR2(9) not null,
codigoError number,
textoError varchar2(64)
);
