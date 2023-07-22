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
public class FourStars extends Hoteles {
    
    protected Gym g;
    protected Restaurants res;

    public FourStars() {
    }

    public FourStars(Gym g, Restaurants res, Integer cantHabitaciones, Integer numCamas, Integer numPisos, Integer price, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(cantHabitaciones, numCamas, numPisos, price, name, direction, numDirection, localidad, gerent);
        this.g = g;
        this.res = res;
    }

    @Override
    public String toString() {
        return "FourStars{" + "Gym: " + g + ", Restaurant: " + res + '}';
    }
    
    
    
}
