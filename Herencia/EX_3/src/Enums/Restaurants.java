/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author tomyv
 */
public enum Restaurants {

    RESTAURANT_1("DELIZIA", 100),
    RESTAURANT_2("GASTON", 75),
    RESTAURANT_3("SABORE", 50),
    RESTAURANT_4("ABROSIA", 200),
    RESTAURANT_5("GUSTO", (150)),
    RESTAURANT_6("SABROSO", 90),
    RESTAURANT_7("DELICIUM", 300);
    
    private String name;
    private Integer cant;

    private Restaurants() {
    }

    private Restaurants(String name, Integer cant) {
        this.name = name;
        this.cant = cant;
    }

    public String getName() {
        return name;
    }

    public Integer getCant() {
        return cant;
    }

    @Override
    public String toString() {
        return "Restaurants{" + "Name: " + name + ", Capacidad: " + cant + '}';
    }
    
    
}
