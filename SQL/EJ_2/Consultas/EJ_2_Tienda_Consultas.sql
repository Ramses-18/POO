-- 1. Lista el nombre de todos los productos que hay en la tabla producto.
SELECT * FROM producto;

-- 2. Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT nombre, precio FROM producto;

-- 3. Lista todas las columnas de la tabla producto.
SELECT * FROM producto;

-- 4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT nombre, ROUND(precio) FROM producto;

-- 5. Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT codigo_fabricante FROM producto;

-- 6 .Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar los repetidos.
SELECT DISTINCT codigo_fabricante FROM producto;

-- 7. Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT nombre FROM fabricante ORDER BY nombre;

-- 8. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y 
-- en segundo lugar por el precio de forma descendente.
SELECT nombre, precio FROM producto ORDER BY nombre ASC , precio DESC; 

-- 9. Devuelve una lista con las 5 primeras filas de la tabla fabricante.
SELECT * FROM fabricante LIMIT 5;

-- 10 .Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;

-- 11. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre,precio FROM producto WHERE precio = (SELECT MAX(precio) FROM producto);
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- 12. Lista el nombre de los productos que tienen un precio menor o igual a $120.
SELECT nombre, precio FROM producto WHERE precio <= 120 ORDER BY precio;

-- 13. Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador BETWEEN.
SELECT nombre, precio FROM producto WHERE precio BETWEEN 60 AND 200;
SELECT nombre, precio FROM producto WHERE precio >= 60 AND precio <= 200;
SELECT * FROM producto;
UPDATE producto SET precio = 200 WHERE codigo = 1;
UPDATE producto SET precio = 120 WHERE codigo = 5;
UPDATE producto SET precio = 120 WHERE codigo BETWEEN 5 AND 8;

-- 14. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.
SELECT codigo FROM producto WHERE codigo IN (1,3,5);

-- 15. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
SELECT nombre FROM producto WHERE nombre LIKE '%Portátil%';
SELECT nombre FROM producto WHERE nombre LIKE '%Disco%'; 

-- Consultas Multitabla

-- 1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante,
-- de todos los productos de la base de datos.
SELECT p.codigo, p.nombre, f.codigo AS 'cFab', f.nombre AS 'F' FROM producto p 
INNER JOIN  fabricante f ON f.codigo = p.codigo_fabricante;

-- 2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos
-- los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT p.codigo, p.nombre, p.precio, f.codigo AS 'cFab', f.nombre AS 'nombre' FROM producto p 
INNER JOIN  fabricante f ON f.codigo = p.codigo_fabricante
ORDER BY f.nombre;

-- 3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT p.nombre, p.precio, f.nombre AS 'NOMBRE_FABRICANTE' 
FROM producto p INNER JOIN fabricante f ON f.codigo = p.codigo_fabricante
ORDER BY p.precio LIMIT 1;

-- 4. Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT * FROM producto p INNER JOIN fabricante f ON f.codigo = p.codigo_fabricante
WHERE f.nombre LIKE '%lenovo%';

-- 5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200.
SELECT * FROM producto;
SELECT * FROM producto p INNER JOIN fabricante f ON f.codigo = p.codigo_fabricante
WHERE f.nombre LIKE '%crucial%' AND p.precio = 120;

-- 6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard. Utilizando el operador IN.
SELECT * FROM producto p INNER JOIN fabricante f ON f.codigo = p.codigo_fabricante
WHERE f.nombre IN ('asus','Hewlett-Packard');

-- 7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos 
-- que tengan un precio mayor o igual a $180. Ordene el resultado en primer lugar por el precio (en orden descendente)
-- y en segundo lugar por el nombre (en orden ascendente).
SELECT p.nombre AS 'nombre_producto', p.precio, f.nombre AS 'nombre_fabricante'
FROM producto p INNER JOIN fabricante f ON f.codigo = p.codigo_fabricante
WHERE p.precio >= 180 ORDER BY p.precio DESC, f.nombre;

-- 1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos.
-- El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT * FROM fabricante f LEFT OUTER JOIN producto p ON f.codigo = p.codigo_fabricante;

-- 2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT * FROM fabricante;
SELECT * FROM fabricante f
LEFT OUTER JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE NOT EXISTS(SELECT * FROM producto WHERE f.codigo = p.codigo_fabricante);

-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).

SELECT * 
FROM producto, fabricante
WHERE fabricante.nombre LIKE 'LENOVO';

SELECT * 
FROM producto LEFT JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre LIKE 'lenovo';

/*2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto
más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).*/
SELECT *
FROM producto
WHERE producto.precio =
 (SELECT MAX(precio) FROM producto WHERE producto.codigo_fabricante = 
(SELECT fabricante.codigo FROM fabricante WHERE fabricante.nombre LIKE 'LENOVO') 
);

-- 3. Lista el nombre del producto más caro del fabricante Lenovo.
SELECT producto.nombre
FROM producto
WHERE producto.precio =
(SELECT MAX(precio)
 FROM producto
 WHERE producto.codigo_fabricante = 
 (SELECT fabricante.codigo
   FROM fabricante
   WHERE fabricante.nombre
   LIKE 'LENOVO') 
);

-- 4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT * FROM producto
WHERE producto.codigo_fabricante > (SELECT AVG(producto.precio) FROM producto WHERE codigo_fabricante = (
SELECT producto.nombre LIKE 'asus'));

-- Subconsultas con IN y NOT IN

-- 1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
SELECT distinct nombre FROM fabricante WHERE fabricante.codigo
IN (SELECT producto.codigo_fabricante FROM producto);

-- 2. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).
SELECT nombre FROM fabricante WHERE fabricante.codigo
NOT IN (SELECT producto.codigo_fabricante FROM producto);

-- Subconsultas (En la cláusula HAVING)
-- 1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número
-- de productos que el fabricante Lenovo.
SELECT f.nombre, COUNT(*) FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante GROUP BY f.nombre;

SELECT nombre, COUNT(*) FROM fabricante WHERE COUNT(*) = (SELECT * FROM  
(SELECT nombre FROM fabricante WHERE nombre LIKE 'Lenovo'));