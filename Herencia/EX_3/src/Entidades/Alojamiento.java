package Entidades;

import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Alojamiento {
    
    protected String name;
    protected String direction;
    protected Integer numDirection;
    protected String localidad;
    protected Gerente gerent;
    protected Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public Alojamiento() {
    }

    public Alojamiento(String name, String direction, Integer numDirection, String localidad, Gerente gerent) {
        this.name = name;
        this.direction = direction;
        this.numDirection = numDirection;
        this.localidad = localidad;
        this.gerent = gerent;
    }

    @Override
    public String toString() {
        return "Alojamiento{" + "Name: " + name + ", Direction: " + direction +
                ", NumDirection: " + numDirection + ", Localidad: " + localidad + ", Gerente: " + gerent + '}';
    }
    
    public Alojamiento createAlojamiento(){
        System.out.println("NOMBRE COMPLETO DEL HOTEL");
        name = sc.next();
        System.out.println("NOMBRE DE LA DIRECCION");
        direction = sc.next();
        System.out.println("NUMERO DE DIRECCION");
        numDirection = sc.nextInt();
        System.out.println("LOCALIDAD");
        gerent = new Gerente();
        gerent.createGerente();
        return new Alojamiento(name,direction,numDirection,localidad,gerent);
    }
    
}
