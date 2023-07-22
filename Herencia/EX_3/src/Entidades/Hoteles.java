/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomyv
 */
public class Hoteles extends Alojamiento {
    
    protected Integer cantHabitaciones;
    protected Integer numCamas;
    protected Integer numPisos;
    protected Integer price;

    public Hoteles() {
    }

    public Hoteles(Integer cantHabitaciones, Integer numCamas, Integer numPisos, Integer price, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(name, direction, numDirection, localidad, gerent);
        this.cantHabitaciones = cantHabitaciones;
        this.numCamas = numCamas;
        this.numPisos = numPisos;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "Hoteles{" + "Cantidad de Habitaciones: " + cantHabitaciones + ", Numeros de Camas: "
                + numCamas + ", Cantidad de Pisos: " + numPisos + ", Price: " + price + '}';
    }

    @Override
    public Alojamiento createAlojamiento() {
        super.createAlojamiento(); 
        System.out.println("CANTIDAD DE HABITACIONES");
        sc.nextInt() = 
        return new Hoteles(cantHabitaciones,numCamas,numPisos,price,name,direction,numDirection,localidad,gerent);
    }
    
    
    
}
