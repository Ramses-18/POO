/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Velero extends Barco {

    protected Integer mastiles;

    public Velero() {
        
    }

    public Velero(Integer mastiles, String matricula, Double eslora, Integer anioFabric) {
        super(matricula, eslora, anioFabric);
        this.mastiles = mastiles;
    }

    public Integer getMastiles() {
        return mastiles;
    }

    public void setMastiles(Integer mastiles) {
        this.mastiles = mastiles;
    }

    public Velero crearVelero() {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Cantidad de mastiles");
        this.mastiles = read.nextInt();
        return new Velero(mastiles,matricula,eslora,anioFabric);
    }

    @Override
    public String toString() {
        return "Velero{" + " Mastiles: " + mastiles + '}';
    }

}
