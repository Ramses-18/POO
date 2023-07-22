package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado
 * o Abierto, esta clase implementará los dos métodos abstractos y los atributos
 * del padre.
 */
public class Polideportivo extends Edificio {

    private String name;
    private Boolean techo;
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Polideportivo() {
    }

    public Polideportivo(String name, Boolean techo, Double ancho, Double alto, Double largo) {
        super(ancho, alto, largo);
        this.name = name;
        this.techo = techo;
    }

    public String getName() {
        return name;
    }

    public Boolean getTecho() {
        return techo;
    }

    @Override
    public double calcularSuperficie() {
        System.out.println("NOMBRE DEL POLIDEPORTIVO");
        this.name = sc.next();
        System.out.println("TIPO DE TECHO ABIERTO CERRADO (A/C)");
        if (sc.next().equalsIgnoreCase("A")) {
            this.techo = false;
        } else {
            this.techo = true;
        }
        System.out.println("ANCHO DEL POLIDEPORTIVO");
        this.ancho = sc.nextDouble();
        System.out.println("LARGO DEL POLIDEPORTIVO");
        this.largo = sc.nextDouble();
        System.out.println("ALTO DEL POLIDEPORTIVO");
        this.alto = sc.nextDouble();
        return (largo * ancho);
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * alto;
    }

    @Override
    public String toString() {
        return "Edificio{" + " Ancho: " + ancho + ", Alto: " + alto + ", Largo: " + largo + '}' 
                + " Polideportivo{" + " Name: " + name + ", Techo: " + techo + '}';
    }

    
}
