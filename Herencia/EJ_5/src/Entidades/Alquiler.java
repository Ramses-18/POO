/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author tomyv
 *
 * En un puerto se alquilan amarres para barcos de distinto tipo. Para cada
 * Alquiler se guarda: el nombre, documento del cliente, la fecha de alquiler,
 * fecha de devolución, la posición del amarre y el barco que lo ocupará.
 */
public class Alquiler {
    
    protected String name;
    protected Integer dni;
    protected Date fechaAlquiler;
    protected Date fechaDevolucion;
    protected Integer posAmarre;
    protected Barco bar;
    
    
    
    
    
    
}
