package Service;

import Entidades.Edificio;
import Entidades.EdificioDeOficinas;
import Entidades.Polideportivo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Service {

//Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
//dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
//métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
//superficie y el volumen de cada edificio.
//Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
//techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
//cantPersonas() y mostrar los resultados de cada edificio de oficinas.
    public void all() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Boolean flag = true;
        do {
            System.out.println("USTED TIENE");
            System.out.println("1 - POLIDEPORTIVO");
            System.out.println("2 - EDIFICIO DE OFICINAS");
            switch (sc.nextInt()) {
                case 1:
                    Polideportivo p = new Polideportivo();
                    System.out.println("LA SUPERFICIE ES DE " + p.calcularSuperficie() + " M3 PARA " + p.getName().toUpperCase());
                    System.out.println("EL VOLUMEN ES DE " + p.calcularVolumen() + " M4");
                    flag = false;
                    System.out.println(p.toString());
                    break;
                case 2:
                    EdificioDeOficinas edo = new EdificioDeOficinas();
                    System.out.println("LA SUPERFICIE ES DE " + edo.calcularSuperficie() + " M3 PARA " + edo.getEmpresa().toUpperCase());
                    System.out.println("EL VOLUMEN ES DE " + edo.calcularVolumen() + " M4 ");
                    System.out.println("EN UN PISO ENTRAN DE " + edo.getEmpresa() + " ENTRAN " + (edo.getOficinas() * edo.getPerxoficinas()) + " PERSONAS");
                    System.out.println("ENTRAN " + (edo.getOficinas() * edo.getPerxoficinas() * edo.getPisos()) + " PERSONAS");
                    flag = false;
                    System.out.println(edo.toString());
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
           
        } while (flag);
    }

}
