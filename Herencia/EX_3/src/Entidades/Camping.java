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
public class Camping extends Extra_Hoteleros {

    protected Integer capMaxDeCarpas;
    protected Integer cantBanios;
    protected Boolean restaurant;

    public Camping() {
    }

    public Camping(Integer capMaxDeCarpas, Integer cantBanios, Boolean restaurant, Boolean type, Double metrosCuadrados, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(type, metrosCuadrados, name, direction, numDirection, localidad, gerent);
        this.capMaxDeCarpas = capMaxDeCarpas;
        this.cantBanios = cantBanios;
        this.restaurant = false;
    }

    @Override
    public String toString() {
        return "Camping{" + "CapMaxDeCarpas: " + capMaxDeCarpas
                + ", Cantidad De Baños: " + cantBanios + ", Restaurant: " + restaurant + '}';
    }

}
