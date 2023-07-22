/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Enums.Gym;
import Enums.Restaurants;

/**
 *
 * @author tomyv
 */
public class FiveStars extends FourStars {
 
    protected Integer salConfer;
    protected Integer cantSuits;
    protected Integer cantLim;

    public FiveStars() {
    }
    
    public FiveStars(Integer salConfer, Integer cantSuits, Integer cantLim, Gym g, Restaurants res, Integer cantHabitaciones, Integer numCamas, Integer numPisos, Integer price, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(g, res, cantHabitaciones, numCamas, numPisos, price, name, direction, numDirection, localidad, gerent);
        this.salConfer = salConfer;
        this.cantSuits = cantSuits;
        this.cantLim = cantLim;
    }

    @Override
    public String toString() {
        return "FiveStars{" + "Salas de Conferencia: " + salConfer + 
                ", Cantidad de Suits: " + cantSuits + ", Cantidad de Limosinas: " + cantLim + '}';
    }
    
}
