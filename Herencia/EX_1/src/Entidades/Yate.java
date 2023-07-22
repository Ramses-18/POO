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
public class Yate extends Lancha {

    private Integer camarotes;

    public Yate() {
    }

    public Yate(Integer camarotes, Integer potencia, String matricula, Double eslora, Integer anioFabric) {
        super(potencia, matricula, eslora, anioFabric);
        this.camarotes = camarotes;
    }

    public Integer getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(Integer camarotes) {
        this.camarotes = camarotes;
    }

    @Override
    public Integer getPotencia() {
        return potencia;
    }

    @Override
    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Yate crearYate() {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Potencia en CV");
        this.potencia = read.nextInt();
        System.out.println("Cantidad de camarotes del yate");
        this.camarotes = read.nextInt();
        return new Yate(camarotes,potencia,matricula,eslora,anioFabric);
    }

    @Override
    public String toString() {
        return "Yate{" + " Camarotes: " + camarotes + " Potencia: " + potencia + '}';
    }

}
