-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT Nombre FROM jugadores ORDER BY Nombre;

-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.
SELECT Nombre,Peso FROM jugadores WHERE Posicion = 'C' AND Peso > 200 ORDER BY Nombre;

-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT Nombre FROM equipos ORDER BY Nombre;

-- 4. Mostrar el nombre de los equipos del este (East).
SELECT Nombre, Conferencia FROM equipos WHERE Conferencia = 'East';

-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT Nombre, Ciudad FROM equipos WHERE Ciudad LIKE 'c%' ORDER BY Nombre;

-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT * FROM jugadores ORDER BY Nombre_equipo;

-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
SELECT * FROM jugadores WHERE Nombre_equipo = 'Raptors' ORDER BY nombre;

-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
SELECT * FROM estadisticas; 
SELECT jugadores.Nombre, Puntos_por_partido, Asistencias_por_partido, Rebotes_por_partido, Tapones_por_partido
FROM estadisticas 
JOIN jugadores ON estadisticas.jugador = jugadores.codigo
WHERE jugadores.Nombre LIKE 'PAU GASOL';

-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT jugadores.Nombre, temporada, Puntos_por_partido, Asistencias_por_partido, Rebotes_por_partido, Tapones_por_partido
FROM estadisticas 
JOIN jugadores ON estadisticas.jugador = jugadores.codigo
WHERE jugadores.Nombre LIKE 'PAU GASOL' AND estadisticas.temporada = '04/05';

-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.
SELECT jugadores.Nombre, estadisticas.jugador, ROUND(SUM(estadisticas.Puntos_por_partido),2) AS 'PUNTOS TOTALES' FROM estadisticas
JOIN jugadores ON estadisticas.jugador = jugadores.codigo
GROUP BY estadisticas.jugador ORDER BY estadisticas.jugador;

--  11. Mostrar el número de jugadores de cada equipo.
SELECT COUNT(Nombre), Nombre_equipo FROM jugadores GROUP BY Nombre_equipo;

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT jugadores.Nombre, estadisticas.jugador, ROUND(SUM(estadisticas.Puntos_por_partido),2) AS 'PUNTOS_TOTALES' FROM estadisticas
JOIN jugadores ON estadisticas.jugador = jugadores.codigo
GROUP BY estadisticas.jugador ORDER BY PUNTOS_TOTALES DESC LIMIT 1;

-- 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT equipos.Nombre, equipos.Conferencia, equipos.Division, jugadores.Altura FROM equipos
JOIN jugadores ON equipos.Nombre = jugadores.Nombre_equipo
ORDER BY jugadores.Altura DESC LIMIT 1;

-- 14. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
SELECT *, ABS(puntos_local - puntos_visitante) AS 'D' FROM partidos 
GROUP BY codigo HAVING D = 
(SELECT MAX(ABS(puntos_local - puntos_visitante)) AS 'D' 
FROM partidos)
ORDER BY D DESC;

-- 15. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
SELECT codigo, equipo_local, equipo_visitante,puntos_local, puntos_visitante,
       CASE
           WHEN puntos_local > puntos_visitante THEN equipo_local
           WHEN puntos_local < puntos_visitante THEN equipo_visitante
           ELSE NULL
       END AS equipo_ganador
FROM Partidos;

