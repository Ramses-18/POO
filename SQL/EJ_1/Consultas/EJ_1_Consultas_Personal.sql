SELECT COUNT(id_depto) FROM departamentos;

-- 1) Obtener los datos completos de los empleados.
SELECT * FROM empleados;

-- 2) Obtener los datos completos de los departamentos.
SELECT * FROM departamentos;

-- 3) Listar el nombre de los departamentos.
SELECT DISTINCT nombre_depto FROM departamentos;
SELECT DISTINCT ciudad FROM departamentos;
SELECT DISTINCT nombre_jefe_depto FROM departamentos;
SELECT DISTINCT id_emp, nombre FROM empleados;

-- 4) Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp FROM empleados;

-- 5) Listar todas las comisiones.
SELECT nombre, comision_emp FROM empleados ORDER BY comision_emp ASC;

-- 6) Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT cargo_emp FROM empleados;
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Secretaria';
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Tecnico';
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Investigador';
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Vendedor';
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Mecanico';
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'Jefe Mecanicos';

-- 7) Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
SELECT sex_emp FROM empleados;
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'vendedor' ORDER BY nombre ASC;
SELECT nombre, cargo_emp FROM empleados WHERE cargo_emp = 'secretaria' ORDER BY nombre DESC;
SELECT nombre, sex_emp FROM empleados WHERE sex_emp = 'M' ORDER BY nombre ASC;
SELECT nombre, sex_emp FROM empleados WHERE sex_emp = 'F' ORDER BY nombre DESC;

-- 8) Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT nombre, cargo_emp, sal_emp FROM empleados ORDER BY sal_emp DESC;
SELECT nombre, cargo_emp, sal_emp FROM empleados ORDER BY sal_emp ASC;

-- 9) Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
SELECT nombre_jefe_depto, ciudad FROM departamentos;
SELECT nombre_jefe_depto, ciudad FROM departamentos WHERE ciudad = 'CIUDAD REAL'; 
SELECT nombre_jefe_depto, ciudad FROM departamentos WHERE ciudad = 'BARCELONA'; 
SELECT nombre_jefe_depto, ciudad FROM departamentos WHERE ciudad = 'VALENCIA'; 

-- 10) Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
SELECT id_emp AS 'NOMBRE' FROM empleados;
SELECT sex_emp AS 'CARGO' FROM empleados;
SELECT nombre AS 'SIUU' FROM empleados;
SELECT fec_nac AS 'CR7 GOAT' FROM empleados;
SELECT fec_incorporacion AS 'NANANANAN BATMAN' FROM empleados;
SELECT sal_emp AS 'PEPPA' FROM empleados;
SELECT cargo_emp AS 'BACKYARDIGANS' FROM empleados;
SELECT comision_emp AS 'FACTOUS' FROM empleados;
SELECT id_depto AS 'BANCAN CHAT?' FROM empleados; 

-- 11) Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT nombre, sal_emp, comision_emp, id_depto FROM empleados
WHERE id_depto = 2000 ORDER BY comision_emp DESC;

-- 12) Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta de: sumar el salario y la comisión,
--     más una bonificación de 500. Mostrar el nombre del empleado y el total a pagar, en orden alfabético.
SELECT nombre,(sal_emp + comision_emp + 500) AS 'total' FROM empleados ORDER BY nombre ASC; 

-- 13) Muestra los empleados cuyo nombre empiece con la letra J.
SELECT nombre FROM empleados WHERE nombre LIKE 'J%';
SELECT nombre FROM empleados WHERE nombre LIKE '_A%';
SELECT nombre FROM empleados WHERE nombre LIKE 'E%';

-- 14) Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos empleados que tienen comisión superior a 1000.
SELECT nombre, sal_emp, comision_emp, (sal_emp + comision_emp) AS 'total' FROM empleados WHERE comision_emp > 1000;

-- 15) Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
SELECT nombre, sal_emp, comision_emp,
(sal_emp + comision_emp) AS 'pay' 
FROM empleados WHERE NOT comision_emp;

SELECT nombre, fec_nac, sex_emp 
FROM empleados 
WHERE NOT sex_emp = 'M';

-- 16) Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT nombre 
FROM empleados 
WHERE comision_emp > sal_emp
ORDER BY nombre ASC;

-- 17) Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT nombre, comision_emp, sal_emp FROM empleados WHERE comision_emp <= (sal_emp * 0.30);

-- 18) Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT nombre FROM empleados WHERE nombre NOT LIKE '%MA%';

-- 19) Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o 'Mantenimiento'.
SELECT * FROM departamentos;
SELECT nombre_jefe_depto, nombre_depto FROM departamentos WHERE nombre_depto IN ('VENTAS','INVESTIGACION','MANTENIMIENTO');
SELECT nombre_jefe_depto, ciudad FROM departamentos WHERE ciudad IN ('CIUDAD REAL','BARCELONA'); 

-- 20) Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT nombre_jefe_depto, nombre_depto FROM departamentos WHERE nombre_depto NOT IN ('VENTAS','INVESTIGACION','MANTENIMIENTO');

-- 21) Mostrar el salario más alto de la empresa.
SELECT MAX(sal_emp) FROM empleados;
SELECT MIN(fec_nac) FROM empleados;
SELECT nombre FROM empleados GROUP BY MAX(fec_nac);

-- 22) Mostrar el nombre del último empleado de la lista por orden alfabético.
SELECT MAX(nombre) FROM empleados;
SELECT MIN(nombre) FROM empleados;

-- 23) Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT MAX(sal_emp), MIN(sal_emp), (MAX(sal_emp) - MIN(sal_emp)) AS 'diferencia' FROM empleados;
SELECT MIN(sal_emp) AS 'minimo' FROM empleados;
SELECT MAX(sal_emp) AS 'maximo' FROM empleados;
SELECT MAX(sal_emp) - MIN(sal_emp) AS 'diferencia' FROM empleados;

-- 24) Hallar el salario promedio por departamento.
SELECT id_depto, ROUND(AVG(sal_emp)) FROM empleados GROUP BY id_depto;
SELECT id_depto FROM empleados GROUP BY id_depto;

-- 25) Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
SELECT id_depto, COUNT(*) FROM empleados GROUP BY id_depto HAVING COUNT(id_depto) > 3;
SELECT * FROM empleados WHERE id_depto = 3500;

-- 26) Hallar los departamentos que no tienen empleados.
SELECT id_depto, COUNT(*) FROM empleados GROUP BY id_depto HAVING COUNT(*) = 0;

-- 27) Mostrar la lista de los empleados con su respectivo departamento y el jefe de cada departamento.
SELECT * FROM empleados e INNER JOIN departamentos d ON d.id_depto = e.id_depto; 
SELECT e.id_depto, d.id_depto, e.nombre, d.nombre_depto, d.nombre_jefe_depto FROM departamentos d, empleados e
WHERE e.id_depto = d.id_depto; 

-- 28) Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
SELECT e.nombre, e.sal_emp, e.id_depto,(SELECT ROUND(AVG(sal_emp),2) FROM empleados) AS 'siuu'
FROM empleados e WHERE e.sal_emp >= (SELECT AVG(sal_emp) FROM empleados);
