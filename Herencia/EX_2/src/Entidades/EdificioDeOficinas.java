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
 *
 * Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de
 * personas por oficina y número de pisos. Esta clase implementará los dos
 * métodos abstractos y los atributos del padre.
 */
public class EdificioDeOficinas extends Edificio {

    private String empresa;
    private Integer oficinas;
    private Integer perxoficinas;
    private Integer pisos;
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public EdificioDeOficinas() {
    }

    public EdificioDeOficinas(String empresa, Integer oficinas, Integer perxoficinas, Integer pisos, Double ancho, Double alto, Double largo) {
        super(ancho, alto, largo);
        this.empresa = empresa;
        this.oficinas = oficinas;
        this.perxoficinas = perxoficinas;
        this.pisos = pisos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public Integer getOficinas() {
        return oficinas;
    }

    public Integer getPerxoficinas() {
        return perxoficinas;
    }

    public Integer getPisos() {
        return pisos;
    }

    @Override
    public double calcularSuperficie() {
        cantPersonas();
        System.out.println("ANCHO DEL EDIFICIO");
        this.ancho = sc.nextDouble();
        System.out.println("LARGO DEL EDIFICIO");
        this.largo = sc.nextDouble();
        System.out.println("ALTO DEL EDIFICIO");
        this.alto = sc.nextDouble();
        return (oficinas * largo * alto * pisos) + (oficinas * ancho * alto * pisos) + (largo * ancho);
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * alto * pisos;
    }

    // Crear el método cantPersonas(), que muestre cuantas personas entrarían en un piso y cuantas en todo el edificio.
    public void cantPersonas() {
        System.out.println("NOMBRE DE LA EMPRESA");
        this.empresa = sc.next();
        System.out.println("NUMERO DE OFICINAS");
        this.oficinas = sc.nextInt();
        System.out.println("PERSONAS X PISO");
        this.perxoficinas = sc.nextInt();
        System.out.println("CANTIDAD DE PISOS");
        this.pisos = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Edificio{" + " Ancho: " + ancho + ", Alto: " + alto + ", Largo: " + largo + '}'
                + " Edificio_De_Oficinas{" + " Oficinas: " + oficinas
                + ", Personas_Por_Oficinas: " + perxoficinas + ", Pisos: " + pisos + '}';
    }

}
