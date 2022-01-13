/* tabla usuarios */
CREATE TABLE USUARIOS (
login VARCHAR2(15),
password VARCHAR2(9),
nombre VARCHAR2(25),
apellidos VARCHAR2(30),
direccion VARCHAR2(30),
cp VARCHAR2(5),
localidad VARCHAR2(30),
provincia VARCHAR2(25),
pais VARCHAR2(15),
f_nacimiento DATE,
f_ingreso DATE,
correo VARCHAR2(25),
credito NUMBER,
sexo VARCHAR2(1)
);

/* tabla partidas */
CREATE TABLE PARTIDAS (
codigo VARCHAR2(15),
nombre VARCHAR2(25),
estado VARCHAR2(1),
cod_juego VARCHAR2(15),
fecha_inicio_partida DATE,
hora_inicio_partida VARCHAR2(10),
cod_creador_partida VARCHAR2(15)
);

/* Tabla JUEGOS */
CREATE TABLE JUEGOS (
codigo VARCHAR2(15),
nombre VARCHAR2(25),
descripcion VARCHAR2(200)
);
/* tabla UNEN */
CREATE TABLE UNEN (
codigo_partida VARCHAR2(15),
codigo_usuario VARCHAR2(15)
);

 

INSERT INTO USUARIOS VALUES('anamat56','JD9U6?','ANA M.','MATA VARGAS','GARCILASO DE LA VEGA',08924,'SANTA COLOMA DE GRAMANET','BARCELONA','ESPA�A','08/25/1974','10/10/2007','anamat56@hotmail.com',213,'M');
INSERT INTO USUARIOS VALUES('alecam89','5;5@PK','ALEJANDRO EMILIO','CAMINO LAZARO','PEDRO AGUADO BLEYE',34004,'PALENCIA','PALENCIA','ESPA�A','05/03/1976','10/15/2010','alecam89@hotmail.com',169,'H');
INSERT INTO USUARIOS VALUES('verbad64','MP49HF','VERONICA','BADIOLA PICAZO','BARRANCO GUINIGUADA',35015,'PALMAS DE GRAN CANARIA,LAS','PALMAS (LAS)','ESPA�A','01/28/1984','10/23/2010','verbad64@hotmail.com',437,'M');
INSERT INTO USUARIOS VALUES('conmar76','O1<N9U','CONSUELO','MARTINEZ RODRIGUEZ','ROSA',04002,'ALMER�A','ALMER�A','ESPA�A','08/09/1978','03/25/2007','conmar76@yahoo.com',393,'M');
INSERT INTO USUARIOS VALUES('encpay57','FYC3L5','ENCARNACI�N','PAYO MORALES','MULLER,AVINGUDA',43007,'TARRAGONA','TARRAGONA','ESPA�A','05/04/1993','01/06/2010','encpay57@yahoo.com',318,'M');
INSERT INTO USUARIOS VALUES('mandia79','00JRIH','MANUELA','DIAZ COLAS','214 (GENOVA)',07015,'PALMA DE MALLORCA','BALEARES','ESPA�A','07/14/1979','07/16/2008','mandia79@hotmail.com',255,'M');
INSERT INTO USUARIOS VALUES('alibar52','IER8S','ALICIA MARIA','BARRANCO CALLIZO','HECTOR VILLALOBOS',29014,'M�LAGA','M�LAGA','ESPA�A','08/21/1993','09/19/2010','alibar52@hotmail.com',486,'M');
INSERT INTO USUARIOS VALUES('adofid63',';82=MH','ADOLFO','FIDALGO DIEZ','FORCALL',12006,'CASTELL�N DE LA PLANA','CASTELL�N','ESPA�A','08/11/1981','03/02/2008','adofid63@gmail.com',154,'H');
INSERT INTO USUARIOS VALUES('jesdie98','X565ZS','JESUS','DIEZ GIL','TABAIBAL',35213,'TELDE','PALMAS (LAS)','ESPA�A','10/23/1981','09/13/2009','jesdie98@gmail.com',152,'H');
INSERT INTO USUARIOS VALUES('pedsan70','T?5=J@','PEDRO','SANCHEZ GUIL','PINTOR ZULOAGA',03013,'ALACANT/ALICANTE','ALICANTE','ESPA�A','12/01/1983','06/15/2008','pedsan70@yahoo.com',21,'H');
INSERT INTO USUARIOS VALUES('diahue96','LSQZMC','DIANA','HUERTA VALIOS','JOAQUIN SALAS',39011,'SANTANDER','CANTABRIA','ESPA�A','04/25/1984','07/31/2009','diahue96@yahoo.com',395,'M');
INSERT INTO USUARIOS VALUES('robrod74','<LQMLP','ROBERTO','RODRIGUEZ PARMO','CASTILLO HIDALGO',51002,'CEUTA','CEUTA','ESPA�A','06/28/1978','03/16/2009','robrod74@gmail.com',486,'H');
INSERT INTO USUARIOS VALUES('milgar78','SF=UZ8','MILAGROSA','GARCIA ELVIRA','PEDRALBA',28037,'MADRID','MADRID','ESPA�A','04/12/1983','05/15/2008','milgar78@gmail.com',330,'M');
INSERT INTO USUARIOS VALUES('frabar93','19JZ7@','FRANCISCA','BARRANCO RODRIGUEZ','BALSAS, LAS',26006,'LOGRO�O','RIOJA (LA)','ESPA�A','09/21/1986','02/16/2008','frabar93@gmail.com',75,'M');
INSERT INTO USUARIOS VALUES('migarc93','AAFLTW','MIGUEL ANGEL','ARCOS ALONSO','ISAAC ALBENIZ',04008,'ALMER�A','ALMER�A','ESPA�A','03/01/1991','06/16/2010','migarc93@hotmail.com',23,'H');


/* PARTIDAS  */
INSERT INTO PARTIDAS VALUES('1','Billar_migarc93_18/7','1','12','07/18/2011','00:47:40','migarc93');
INSERT INTO PARTIDAS VALUES('2','Chinch�n_mandia79_2/10','1','6','10/02/2011','01:47:00','mandia79');
INSERT INTO PARTIDAS VALUES('3','Canasta_alibar52_26/2','0','8','02/26/2011','08:57:33','alibar52');
INSERT INTO PARTIDAS VALUES('4','Damas_verbad64_16/3','1','4','03/16/2011','00:53:00','verbad64');
INSERT INTO PARTIDAS VALUES('5','Chinch�n_alibar52_9/9','1','6','09/09/2011','09:10:22','alibar52');
INSERT INTO PARTIDAS VALUES('6','Oca_pedsan70_21/12','0','2','12/21/2011','18:53:17','pedsan70');
INSERT INTO PARTIDAS VALUES('7','Canasta_encpay57_18/2','0','8','02/18/2011','09:41:02','encpay57');
INSERT INTO PARTIDAS VALUES('8','Pocha_adofid63_26/10','1','10','10/26/2011','02:23:43','adofid63');
INSERT INTO PARTIDAS VALUES('9','Damas_diahue96_25/6','1','4','06/25/2011','18:11:14','diahue96');
INSERT INTO PARTIDAS VALUES('10','Parch�s_encpay57_31/7','1','1','07/31/2011','21:21:36','encpay57');

/* JUEGOS  */
INSERT INTO JUEGOS VALUES('1','Parch�s','El parch�s es un juego de mesa derivado del pachisi y similar al ludo y al parcheesi');
INSERT INTO JUEGOS VALUES('2','Oca','El juego de la oca es un juego de mesa para dos o m�s jugadores');
INSERT INTO JUEGOS VALUES('3','Ajedrez','El ajedrez es un juego entre dos personas, cada una de las cuales dispone de 16 piezas m�viles que se colocan sobre un tablero dividido en 64 escaques');
INSERT INTO JUEGOS VALUES('4','Damas','Las damas es un juego de mesa para dos contrincantes');
INSERT INTO JUEGOS VALUES('5','Poker','El p�quer es un juego de cartas de los llamados de "apuestas"');
INSERT INTO JUEGOS VALUES('6','Chinch�n','El chinch�n es un juego de naipes de 2 a 8 jugadores');
INSERT INTO JUEGOS VALUES('7','Mus','El mus es un juego de naipes, originario de Navarra, que en la actualidad se encuentra muy extendido por toda Espa�a');
INSERT INTO JUEGOS VALUES('8','Canasta','La canasta o rummy-canasta es un juego de naipes, variante del rummy');
INSERT INTO JUEGOS VALUES('9','Domin�','El domin� es un juego de mesa en el que se emplean unas fichas rectangulares');
INSERT INTO JUEGOS VALUES('10','Pocha','La pocha es un juego de cartas que se juega con la baraja espa�ola');
INSERT INTO JUEGOS VALUES('11','Backgammon','Cada jugador tiene quince fichas que va moviendo entre veinticuatro tri�ngulos (puntos) seg�n el resultado de sus dos dados');
INSERT INTO JUEGOS VALUES('12','Billar','El billar es un deporte de precisi�n que se practica impulsando con un taco un n�mero variable de bolas'); 

/* UNEN  */
INSERT INTO UNEN VALUES ('4','ascbar65');
INSERT INTO UNEN VALUES ('3','norlob93');
INSERT INTO UNEN VALUES ('6','norlob93');
INSERT INTO UNEN VALUES ('2','antcor77');
INSERT INTO UNEN VALUES ('2','anavaz83');
INSERT INTO UNEN VALUES ('2','jesvel57');
INSERT INTO UNEN VALUES ('4','marram77');
INSERT INTO UNEN VALUES ('3','virlue50');
INSERT INTO UNEN VALUES ('5','susizq56');
INSERT INTO UNEN VALUES ('8','virlue50');
INSERT INTO UNEN VALUES ('6','marram77');
INSERT INTO UNEN VALUES ('4','mirtom67');
INSERT INTO UNEN VALUES ('5','oscmar67');
INSERT INTO UNEN VALUES ('4','virlue50');
INSERT INTO UNEN VALUES ('5','susizq56');