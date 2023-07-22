/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Interfaces.calculosFormas;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public final class Circulo implements calculosFormas {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private double radio;

    public Circulo() {
    }
        
    @Override
    public double calcularArea() {
        System.out.println("RADIO");
        radio = sc.nextDouble();
        return PI * (Math.pow(radio, 2));
    }

    @Override
    public double calcularPerimetro() {
        return PI * (radio*2);
    }

    

}
