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
public class Rectangulo implements calculosFormas{
    
    private double base;
    private double altura;
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Rectangulo() {
    }

    @Override
    public double calcularArea() {
        //Área rectángulo: base * altura    
        System.out.println("BASE DEL RECTANGULO");
        base = sc.nextDouble();
        System.out.println("ALTURA DEL RECTANGULO");
        altura = sc.nextDouble();
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        // Perímetro rectángulo: (base + altura) * 2.  
        return (base + altura) * 2;
    }
    
}
