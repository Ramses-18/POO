package Servicios;

import Entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author tomyv En el paquete Servicios crear PersonaServicio con los
 * siguientes 3 métodos: Inicializar un objeto de la clase Persona ejercicio 3
 * de la guía 8 Servicios, a null y tratar de invocar el método esMayorDeEdad()
 * a través de ese objeto. Luego, englobe el código con una cláusula try-catch
 * para probar la nueva excepción que debe ser controlada.
 */
public class PersonaServicio {

    Persona p1 = new Persona();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    //a) Método esMayorDeEdad(): indica si la persona es mayor de edad. La función devuelve un booleano.
    public boolean esMayorDeEdad(Persona p) {
        
        try {
            if (p.getEdad() >= 18) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No hay edad asignadinha " + e.fillInStackTrace());
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
        
        return false;
    }

    //b)Metodo crearPersona(): el método crear persona, le pide los valores de los atributos al usuario y
    //después se le asignan a sus respectivos atributos para llenar el objeto Persona.
    //Además, comprueba que el sexo introducido sea correcto, es decir, H, M o O. Si no es correcto se
    //deberá mostrar un mensaje
    public String crearPersona() {
        System.out.println("¿COMO TE LLAMAS?");
        p1.setNombre(sc.next());
        System.out.println("¿CUANTOS AÑOS TENES?");
        p1.setEdad(sc.nextInt());
        System.out.println("¿SEXO(H/M/O)?");
        for (int i = 0; i < 30000; i++) {
            p1.setSexo(sc.next().toUpperCase());
            if (p1.getSexo().toUpperCase().equals("H") || p1.getSexo().toUpperCase().equals("O") || p1.getSexo().toUpperCase().equals("M")) {
                i = 30000;
            } else {
                System.out.println("POR FAVOR INGRESA (H)(M)(O)");
            }
        }
        System.out.println("¿CUANTO METROS MEDIS?");
        p1.setAltura(sc.nextDouble());
        System.out.println("¿CUANTOS KILOS PESAS " + p1.getNombre().toUpperCase() + "?");
        p1.setPeso(sc.nextDouble());
        return p1.getNombre();
    }

    /*
    c) Método calcularIMC(): calculara si la persona está en su peso idea (peso en kg/(altura^2 en mt2)).
    Si esta fórmula da por resultado un valor menor que 20, significa que la persona está por debajo de su peso ideal
    y la función devuelve un -1. Si la fórmula da por resultado un número entre 20 y 25 (incluidos),
    significa que la persona está en su peso ideal y la función devuelve un 0.
    Finalmente, si el resultado de la fórmula es un valor mayor que 25 significa que la persona tiene sobrepeso,
    y la función devuelve un 1.
     */
    public int calcularIMC() {
        p1.setPeso(p1.getPeso() / (p1.getAltura() * p1.getAltura()));
        if (p1.getPeso() < 20) {
            return -1;
        } else if (p1.getPeso() >= 20 || p1.getPeso() <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

}
