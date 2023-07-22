/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomyv
 *
 * Crear una superclase llamada Edificio con los siguientes atributos: ancho,
 * alto y largo. La clase edificio tendrá como métodos:
 * 
 * • Método calcularSuperficie(): calcula la superficie del edificio.
 * • Método calcularVolumen(): calcula el volumen del edifico. 
 * 
 * Estos métodos serán abstractos y los implementarán las siguientes clases:
 */
public abstract class Edificio {
    
    protected Double ancho;
    protected Double alto;
    protected Double largo;

    public Edificio() {
    }

    public Edificio(Double ancho, Double alto, Double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }
        
    public abstract double calcularSuperficie();
    
    public abstract double calcularVolumen();    
    
}

