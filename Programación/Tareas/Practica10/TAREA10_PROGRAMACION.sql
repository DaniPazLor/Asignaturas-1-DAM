select * from terminos;
/
INSERT INTO TERMINOS(VALOR, NUMERO_MUESTRAS) VALUES ('estanterias',0);  
/
SELECT VALOR FROM TERMINOS WHERE VALOR LIKE '%'||?||'%';
/
SELECT SCORE(1) from TERMINOS 
           WHERE CONTAINS(text, 'ill', 1) > 0
           ORDER BY SCORE(1) DESC;
