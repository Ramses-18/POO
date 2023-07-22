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

//CREAMOS LOS ENUMS CON LAS CARACTERISTICAS DE LOS PERROS YA ESTABLECIDAS.
public enum Perro {
    PEPE("BEAGLE", 2, "BIG"),SULTAN("PITBULL",5,"MEDIUM"),
    BELLA("COCKER",8,"SKINNY"),WILSON("PASTOR ALEMAN",10,"ENORMOUS");

    private final String raza;
    private final int edad;
    private final String tamanio;

    private Perro(String raza, int edad, String tamanio) {
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public static Perro getPEPE() {
        return PEPE;
    }

    public static Perro getSULTAN() {
        return SULTAN;
    }

    public static Perro getBELLA() {
        return BELLA;
    }

    public static Perro getWILSON() {
        return WILSON;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return  "IS A " + raza + ", IS " + edad + " YEARS OLD AND IS " + tamanio ;
    }
    
    

}
