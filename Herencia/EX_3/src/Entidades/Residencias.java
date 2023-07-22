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
public class Residencias extends Extra_Hoteleros {
    
    private Integer cantHab;
    private Boolean descGremios;
    private Boolean CampDeport;

    public Residencias() {
    }

    public Residencias(Integer cantHab, Boolean descGremios, Boolean CampDeport, Boolean type, Double metrosCuadrados, String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        super(type, metrosCuadrados, name, direction, numDirection, localidad, gerent);
        this.cantHab = cantHab;
        this.descGremios = descGremios;
        this.CampDeport = CampDeport;
    }

    @Override
    public String toString() {
        return "Residencias{" + "Cantidad de Habitaciones: " + cantHab +
                ", Descuentos a Gremios=" + descGremios + ", Campo Deportivo: " + CampDeport + '}';
    }
    
    
}
