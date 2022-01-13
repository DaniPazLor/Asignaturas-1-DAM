--1.	C�digo y nombre de todos los departamentos.
SELECT ALL codigo,nombre FROM Departamentos;

--2.	Mes y ejercicio de los justificantes de n�mina pertenecientes al empleado cuyo c�digo es 1.
SELECT ALL mes,ejercicio FROM Just_nominas WHERE cod_emp=1;

--3.	N�mero de cuenta y nombre de los empleados cuya retenci�n es mayor o igual que 10.
SELECT ALL cuenta,nombre FROM Empleados WHERE retencion>=10;

--4.	C�digo y nombre de los empleados ordenados ascendentemente por nombre.
SELECT ALL codigo,nombre FROM Empleados ORDER BY nombre ASC;

--5.	Nombre de los empleados que tienen m�s de 2 hijos.
SELECT ALL nombre FROM Empleados WHERE hijos>2;

--6.	C�digo y n�mero de cuenta de los empleados cuyo nombre empiece por 'A' o por 'J'.
SELECT ALL codigo,cuenta FROM Empleados WHERE nombre LIKE 'A%' OR nombre LIKE 'J%';

--7.	N�mero de empleados que hay en la base de datos.
SELECT COUNT(*) FROM Empleados;

--8.	Nombre del primer y �ltimo empleado en t�rminos alfab�ticos.
SELECT MIN(nombre)"Primer Nombre",MAX(nombre)"�ltimo Nombre" FROM Empleados ORDER BY nombre;

--9.	Nombre y n�mero de hijos de los empleados cuya retenci�n es: 8, 10 o 12.
SELECT nombre,hijos FROM Empleados WHERE retencion=8 OR retencion=10 OR retencion=12 ORDER BY nombre;

--10.	N�mero de hijos y n�mero de empleados agrupados por hijos, mostrando s�lo los grupos cuyo n�mero de empleados sea mayor que 1.
SELECT hijos"N�mero de hijos",count(nombre)"N�mero de empleados" FROM Empleados WHERE codigo>1 GROUP BY hijos ORDER BY hijos;

--11.	N�mero de hijos, retenci�n m�xima, m�nima y media de los empleados agrupados por hijos.
SELECT hijos,MAX(retencion),MIN(retencion),AVG(retencion) FROM Empleados GROUP BY hijos ORDER BY hijos; 

--12.	Nombre y funci�n de los empleados que han trabajado en el departamento 1.
SELECT empleados.nombre"Nombre empleado",trabajan.funcion FROM Empleados,Departamentos,Trabajan 
WHERE Empleados.codigo=Trabajan.cod_emp AND Departamentos.codigo=Trabajan.cod_dep AND departamentos.codigo=1 ORDER BY empleados.nombre;

--13.	Nombre del empleado, nombre del departamento y funci�n que han realizado de los empleados que tienen 1 hijo.
SELECT empleados.nombre"Nombre empleado",departamentos.nombre"Departamento",trabajan.funcion FROM Empleados,departamentos,trabajan 
WHERE empleados.codigo=trabajan.cod_emp AND departamentos.codigo=trabajan.cod_dep AND empleados.hijos=1 ORDER BY empleados.nombre;

--14.	Nombre del empleado y nombre del departamento en el que han trabajado empleados que no tienen hijos.
SELECT empleados.nombre"Nombre empleado",departamentos.nombre"Departamento" FROM Empleados,departamentos,trabajan
WHERE empleados.codigo=trabajan.cod_emp AND departamentos.codigo=trabajan.cod_dep AND empleados.hijos=0  ORDER BY empleados.nombre; 

--15.	Nombre del empleado, mes y ejercicio de sus justificantes de n�mina, n�mero de l�nea y cantidad de las l�neas de los justificantes para el empleado cuyo c�digo=1.
SELECT DISTINCT Empleados.nombre,just_nominas.mes,just_nominas.ejercicio,lineas.numero,lineas.cantidad FROM Empleados,just_nominas,lineas
WHERE empleados.codigo=just_nominas.cod_emp AND just_nominas.cod_emp=lineas.cod_emp AND empleados.codigo=1 ORDER BY just_nominas.ejercicio,just_nominas.mes;

--16.	Nombre del empleado, mes y ejercicio de sus justificantes de n�mina para los empleados que han trabajado en el departamento de Ventas.
SELECT DISTINCT Empleados.nombre,just_nominas.mes,just_nominas.ejercicio,departamentos.nombre FROM Empleados,just_nominas,departamentos
WHERE empleados.codigo=just_nominas.cod_emp AND departamentos.nombre='Ventas' ORDER BY Empleados.nombre,just_nominas.ejercicio,just_nominas.mes;

--17.	Nombre del empleado e ingresos totales percibidos agrupados por nombre.
SELECT empleados.nombre,SUM(ingreso) FROM empleados,just_nominas WHERE empleados.codigo=just_nominas.cod_emp GROUP BY empleados.nombre ORDER BY empleados.nombre;

--18.	Nombre de los empleados que han ganado m�s de 2000 � en el a�o 2006. 
SELECT empleados.nombre,SUM(ingreso) FROM Empleados,Just_nominas 
WHERE empleados.codigo=just_nominas.cod_emp AND just_nominas.ejercicio=2006 GROUP BY empleados.nombre HAVING SUM(ingreso)>2000;

--19.	N�mero de empleados cuyo n�mero de hijos es superior a la media de hijos de los empleados.
SELECT  SUM(COUNT(nombre))"N�mero de empleados" FROM Empleados GROUP BY hijos HAVING hijos>(SELECT AVG(hijos) FROM Empleados);

--20.	Nombre de los empleados que m�s hijos tienen o que menos hijos tienen.
SELECT  nombre,hijos FROM Empleados WHERE hijos=(SELECT MIN(hijos) FROM Empleados) UNION
SELECT  nombre,hijos FROM Empleados WHERE hijos=(SELECT MAX(hijos) FROM Empleados) ORDER BY hijos,nombre;

--21.	Nombre de los empleados que no tienen justificante de n�minas.
SELECT nombre FROM Empleados,just_nominas WHERE empleados.codigo=just_nominas.cod_emp(+)  AND empleados.codigo NOT IN (SELECT cod_emp FROM just_nominas) ;

--22.	Nombre y fecha de nacimiento de todos los empleados.
SELECT ALL nombre,fnacimiento FROM Empleados ORDER BY nombre;

--23.	Nombre y fecha de nacimiento con formato "1 de Enero de 2000" y etiquetada la columna como fecha, de todos los empleados.
SELECT ALL nombre,to_char(fnacimiento,'D "de" MONTH "de" YYYY')"fecha" FROM Empleados ORDER BY nombre;

--24.	Nombre de los empleados, nombre de los departamentos en los que ha trabajado y funci�n en may�sculas que ha realizado en cada departamento.
SELECT  empleados.nombre"Nombre empleado",departamentos.nombre"Nombre de departamento",UPPER(trabajan.funcion)"Funcion"
FROM Empleados,Departamentos,Trabajan 
WHERE empleados.codigo=trabajan.cod_emp AND departamentos.codigo=trabajan.cod_dep ORDER BY empleados.nombre;

--25.	Nombre, fecha de nacimiento y nombre del d�a de la semana de su fecha de nacimiento de todos los empleados.
SELECT  nombre,fnacimiento,TO_CHAR(fnacimiento,'DAY')"Dia de nacimiento" FROM empleados ORDER BY empleados.nombre;

--26.	Nombre y edad de los empleados.
SELECT  nombre,(EXTRACT(year FROM sysdate)-EXTRACT(year FROM fnacimiento))"Edad" FROM Empleados;

--27.	Nombre, edad y n�mero de hijos de los empleados que tienen menos de 50 a�os y tienen hijos.
SELECT nombre,(EXTRACT(year FROM sysdate)-EXTRACT(year FROM fnacimiento))"Edad",hijos FROM Empleados
WHERE (EXTRACT(year FROM sysdate)-EXTRACT(year FROM fnacimiento))<50 AND hijos>0;

--28.	Nombre, edad de los empleados y nombre del departamento de los empleados que han trabajado en m�s de un departamento.
SELECT empleados.nombre,(EXTRACT(year FROM sysdate)-EXTRACT(year FROM empleados.fnacimiento))"Edad",departamentos.nombre"Departamnetos"
FROM Empleados,Departamentos,trabajan WHERE empleados.codigo=trabajan.cod_emp AND departamentos.codigo=trabajan.cod_dep
AND empleados.codigo IN (SELECT cod_emp FROM trabajan GROUP BY cod_emp HAVING COUNT(cod_dep)>1) ORDER BY empleados.nombre;

--29.	Nombre, edad y n�mero de cuenta de aquellos empleados cuya edad es m�ltiplo de 3.
SELECT nombre,(EXTRACT(year FROM sysdate)-EXTRACT(year FROM empleados.fnacimiento))"Edad",cuenta FROM Empleados
WHERE MOD((EXTRACT(year FROM sysdate)-EXTRACT(year FROM empleados.fnacimiento)),3)=0;

--30.	Nombre e ingresos percibidos empleado m�s joven y del m�s longevo.
SELECT empleados.nombre,sum(just_nominas.ingreso) FROM Empleados,just_nominas WHERE empleados.codigo=just_nominas.cod_emp 
AND empleados.fnacimiento in (SELECT MIN(fnacimiento) from empleados) OR empleados.fnacimiento in (SELECT MAX(fnacimiento) from empleados)
GROUP BY empleados.nombre ;
