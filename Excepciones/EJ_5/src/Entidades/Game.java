package Entidades;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @param args the command line arguments
 *
 * Escribir un programa en Java que juegue con el usuario a adivinar un número.
 * La computadora debe generar un número aleatorio entre 1 y 500, y el usuario
 * tiene que intentar adivinarlo.
 *
 * Para ello, cada vez que el usuario introduce un valor, la computadora debe
 * decirle al usuario si el número que tiene que adivinar es mayor o menor que
 * el que ha introducido el usuario.
 *
 * Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número
 * de veces que el usuario ha intentado adivinar el número.
 *
 * Si el usuario introduce algo que no es un número, se debe controlar esa
 * excepción e indicarlo por pantalla. En este último caso también se debe
 * contar el carácter fallido como un intento.
 * 
 */
public class Game {

    public void test() {

        Random r = new Random();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int ad = r.nextInt(500) + 1;
        int c = 0;
        System.out.println(ad);
        int n = 0;
        System.out.println("Adivina el numero");
        do {

            try {
                c++;
                n = sc.nextInt();
                if (n < ad) {
                    System.out.println("El numero a adivinar es mas grande");
                }

                if (n > ad) {
                    System.out.println("El numero es mas chico");
                }
                
            } catch (InputMismatchException i) {
                
                System.out.println("Game Over");
                System.out.println(i.fillInStackTrace());
                break;
                
            } finally {
                System.out.println("Cantidad de Intentos: " + c);
                if (n == ad) {
                    System.out.println("Adivinaste");
                    
                }
            }
            
        } while (n != ad);

    }

}
